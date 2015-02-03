package boot.resource;

import boot.dto.ScheduleDTO;
import boot.service.TVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

@RestController()
@RequestMapping("/schedule")
public class TVResource {

    @Autowired
    private TVService tvService;

    @RequestMapping("/{channel}")
    public DeferredResult<List<ScheduleDTO>> getSchedule(@PathVariable String channel) {
        return tvService.getScheduledProgramsHystrix(channel);
    }

    /**
     * Add a RequestMapping and method to lookup your favorite show
     */
    @RequestMapping("/next/{title}")
    public DeferredResult<ScheduleDTO> getNextAiringOfTitle(@PathVariable String title) {
        return tvService.nextOnAir(title);
    }

}
