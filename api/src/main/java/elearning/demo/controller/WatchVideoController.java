package elearning.demo.controller;

import elearning.demo.service.VideoService;
import elearning.demo.utility.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@RequestMapping(value = Constants.URI_API + Constants.URI_VIDEO)
public class WatchVideoController {

    private static final Logger log = LoggerFactory.getLogger(WatchVideoController.class);

    @Autowired
    private VideoService videoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public StreamingResponseBody streamVideo(@PathVariable("id") String id) {

        log.debug("stream video by id @" + id);

        String filePath = videoService.findVideoById(id).getVideoUrl();

        InputStream inputStream = videoService.getVideoStream(filePath);

        return outputStream -> readAndWrite(inputStream, outputStream);

    }

    private void readAndWrite(final InputStream is, OutputStream os)
            throws IOException {
        byte[] data = new byte[2048];
        int read = 0;
        while ((read = is.read(data)) > 0) {
            os.write(data, 0, read);
        }
        os.flush();
    }

}
