package com.taobao.yiwei.designpattern.facade;

import com.taobao.yiwei.designpattern.facade.component.*;

public class HomeTheaterFacade {
    private Amplifier amplifier;
    private CdPlayer cdPlayer;
    private DvdPlayer dvdPlayer;
    private PopcornPopper popper;
    private Projector projector;
    private Screen screen;
    private TheaterLights lights;
    private Tuner tuner;

    public HomeTheaterFacade(Amplifier amplifier,
                             CdPlayer cdPlayer,
                             DvdPlayer dvdPlayer,
                             PopcornPopper popper,
                             Projector projector,
                             Screen screen,
                             TheaterLights lights,
                             Tuner tuner) {
        this.amplifier = amplifier;
        this.tuner = tuner;
        this.dvdPlayer = dvdPlayer;
        this.cdPlayer = cdPlayer;
        this.projector = projector;
        this.lights = lights;
        this.screen = screen;
        this.popper = popper;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        popper.on();
        popper.pop();
        lights.dim();
        screen.down();
        projector.on();
        amplifier.on();
        amplifier.setVolume(5);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        amplifier.off();
        dvdPlayer.stop();
        dvdPlayer.off();
    }
}
