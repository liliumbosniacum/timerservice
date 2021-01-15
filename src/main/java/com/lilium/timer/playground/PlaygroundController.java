package com.lilium.timer.playground;

import com.lilium.timer.info.TimerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timer")
public class PlaygroundController {

    private final PlaygroundService service;

    @Autowired
    public PlaygroundController(PlaygroundService service) {
        this.service = service;
    }

    @PostMapping("/runhelloworld")
    public void runHelloWorldJob() {
        service.runHelloWorldJob();
    }

    @GetMapping
    public List<TimerInfo> getAllRunningTimers() {
        return service.getAllRunningTimers();
    }

    @GetMapping("/{timerId}")
    public TimerInfo getRunningTimer(@PathVariable String timerId) {
        return service.getRunningTimer(timerId);
    }

    @DeleteMapping("/{timerId}")
    public Boolean deleteTimer(@PathVariable String timerId) {
        return service.deleteTimer(timerId);
    }
}
