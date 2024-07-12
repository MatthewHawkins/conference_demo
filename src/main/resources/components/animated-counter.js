import { LitElement, html, css } from 'https://cdn.skypack.dev/lit-element?min';

/**
 * A simple animated counter card component.
 *
 * @element animated-counter
 * @slot icon - The icon slot.
 *
 * @prop {String} lang - The language code for the number format.
 * @prop {String} format-options - The options for the number format.
 * @prop {String} label - The label of the card.
 * @prop {Number} start - The start value of the counter.
 * @prop {Number} speed - The speed of the animation.
 * @prop {String} theme - The theme of the card. Supported values are: `primary`, `danger`, `success`, `info`, `warning`.
 * @prop {Number} value - The value of the counter.
 * @prop {String} valuePrefix - The prefix of the counter.
 * @prop {String} valueSuffix - The suffix of the counter.
 */
class AnimatedCounter extends LitElement {
  static get properties() {
    return {
      formatOptions: { type: Object },
      lang: { type: String },
      label: { type: String },
      start: { type: Number },
      speed: { type: Number },
      theme: { type: String, reflect: true },
      value: { type: Number },
      valuePrefix: { type: String },
      valueSuffix: { type: String },
      active: { type: Boolean, reflect: true },
    };
  }

  static get styles() {
    return css`
    :host {
      display: block;
    }

    [part='card'] {
      display: flex;
      align-items: center;
      padding: 1.5rem;
      border-radius: var(--dwc-border-radius);
      background-color: var(--dwc-surface-3);
      border: 1px solid var(--dwc-color-default);
      gap: 1.5rem;
    }

    [part='content'] {
      flex: 1;
      display: flex;
      flex-direction: column;
    }

    [part='value'] {
      font-size: 2.1rem;
      font-weight: var(--dwc-font-weight-bolder);
    }

    [part='label'] {
      font-size: 1.1rem;
      color: var(--dwc-color-gray-text-light);
    }

    :host ::slotted([slot='icon']) {
      display: flex;
      font-size: 2.1rem;
      color: var(--dwc-color-gray-text-light);
      border-radius: var(--dwc-border-radius-round);
      border: thin solid black;
      padding: 1rem;
    }

    :host([theme='primary']) ::slotted([slot='icon']) {
      color: var(--dwc-color-primary);
      border-color: var(--dwc-color-primary);
      background-color: var(--dwc-color-primary-alt);
    }

    :host([theme='danger']) ::slotted([slot='icon']) {
      color: var(--dwc-color-danger);
      border-color: var(--dwc-color-danger);
      background-color: var(--dwc-color-danger-alt);
    }

    :host([theme='success']) ::slotted([slot='icon']) {
      color: var(--dwc-color-success);
      border-color: var(--dwc-color-success);
      background-color: var(--dwc-color-success-alt);
    }

    :host([theme='info']) ::slotted([slot='icon']) {
      color: var(--dwc-color-info);
      border-color: var(--dwc-color-info);
      background-color: var(--dwc-color-info-alt);
    }

    :host([theme='warning']) ::slotted([slot='icon']) {
      color: var(--dwc-color-warning);
      border-color: var(--dwc-color-warning);
      background-color: var(--dwc-color-warning-alt);
    }`;
  }

  constructor() {
    super();
    this.formatOptions = {
      currency: 'EUR',
      minimumFractionDigits: 2,
      maximumFractionDigits: 2,
    };
    this.lang = 'de-DE';
    this.label = '';
    this.start = 0;
    this.speed = 1000;
    this.theme = '';
    this.value = 0;
    this.valuePrefix = this.valuePrefix || '';
    this.valueSuffix = this.valueSuffix || '';
    this.activeObserver = null; // Initialize observer variable
  }

  connectedCallback() {
    super.connectedCallback();
    this.setupActiveObserver();
  }

  //HARDCODED TO RELOAD WHEN IN JAVALAND APP 
  setupActiveObserver() {
    const targetElement = document.querySelector('dwc-tab[data-tab-index="1"]');
    if (targetElement) {
      const observerConfig = { attributes: true };
      const mutationCallback = (mutationsList, observer) => {
        for (const mutation of mutationsList) {
          if (mutation.type === 'attributes' && mutation.attributeName === 'active') {
            if (mutation.target.hasAttribute('active')) {
              this.animate(this.value);
            }
          }
        }
      };
      this.activeObserver = new MutationObserver(mutationCallback);
      this.activeObserver.observe(targetElement, observerConfig);
    }
  }

  disconnectedCallback() {
    super.disconnectedCallback();
    if (this.activeObserver) {
      this.activeObserver.disconnect();
    }
  }

  updated(changedProperties) {
    if (changedProperties.has('value')) {
      this.animate(this.value);
    }
  }

  format(value) {
    const formatted = new Intl.NumberFormat(this.lang, this.formatOptions).format(value);
    return `${this.valuePrefix || ''}${formatted}${this.valueSuffix || ''}`
  }

  animate(value) {
    const startTime = performance.now();
    const duration = this.speed;

    const animateValue = (timestamp) => {
      const elapsed = timestamp - startTime;
      const progressPercentage = Math.min(elapsed / duration, 1);
      const currentValue = this.start + progressPercentage * (value - this.start);
      this.renderRoot.querySelector('[part="value"]').innerHTML = this.format(currentValue);
      if (elapsed < duration) {
        window.requestAnimationFrame(animateValue);
      }
    };
    window.requestAnimationFrame(animateValue);
  }

  render() {
    return html`
    <div part="card">
      <slot name="icon"></slot>
      <div part="content">
        <div part="value">${this.format(this.value)}</div>
        <div part="label">${this.label}</div>
      </div>
    </div>`;
  }
}

customElements.define('animated-counter', AnimatedCounter);
