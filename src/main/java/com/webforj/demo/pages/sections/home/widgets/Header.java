package com.webforj.demo.pages.sections.home.widgets;

import com.webforj.component.html.elements.Div;

public final class Header extends Div {

  public Header() {

    Div label = new Div();
    label.setHtml(/* html */"""
      <html>
        <Div class="home__header">
          <h1 >webforJ</h1>
          <p>
            A robust and flexible framework that can help you deliver a modern and engaging web user interface with ease. <span>In Java</span>.
          </p>
        </Div>
      </html>
    """);

    Div card = new Div();
    card.addClassName("card card--video");

    // Youtube video = new Youtube("z735T2XOLSw");
    // video.setAutoPlay(true);
    // video.setLoop(true);

    HTMLVideo video = new HTMLVideo();
    video.setSrc("video/intro.mp4");
    video.setAutoplay(true);
    video.setLoop(true);
    video.setMuted(true);
    video.setControls(false);
    video.setPlaysInline(true);
    video.setPreload(true);
  
    card.add(video);

    add(label, card);
  }
}
