package edu.cst.webserver.env;

import edu.cst.webserver.http.HttpRequestException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Demur
 */
public class MimeTypeDetectorTest {

    private String getMimeType(String path) throws IOException, HttpRequestException {
        return MimeTypeDetector.detectMimeType(path);
    }

    /**
     * image/png
     * @throws IOException
     * @throws HttpRequestException
     */
    @Test
    public void testMimeTypeIsImagePNG() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/image.png").getPath();
        String mimeType = getMimeType(path);
        Assert.assertEquals("image/png", mimeType);
    }

    /**
     * image/jpeg
     * @throws IOException
     * @throws HttpRequestException
     */
    @Test
    public void testMimeTypeImageJPEG() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/image.jpeg").getPath();
        String mimeType = getMimeType(path);
        Assert.assertEquals("image/jpeg", mimeType);
    }

    /**
     * image/gif
     * @throws IOException
     * @throws HttpRequestException
     */
    @Test
    public void testMimeTypeImageGIF() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/image.gif").getPath();
        String mimeType = getMimeType(path);
        Assert.assertEquals("image/gif", mimeType);
    }

    /**
     * text/plain
     * text on text.txt
     * @throws IOException
     * @throws HttpRequestException
     */
    @Test
    public void testMimeTypeTextPLAIN() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/text.txt").getPath();
        String mimeType = getMimeType(path);
        Assert.assertEquals("text/plain", mimeType);
    }

    /**
     * text/javascript
     * @throws IOException
     * @throws HttpRequestException
     */
   /* @Test
    public void testMimeTypeTextJS() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/text.js").getPath();
        String mimeType = getMimeType(path);
        Assert.assertEquals("text/javascript", mimeType);
    }*/

    /**
     * text/css
     * @throws IOException
     * @throws HttpRequestException
     */
  /*  @Test
    public void testMimeTypeTextCSS() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/text.css").getPath();
        String mimeType = getMimeType(path);
        Assert.assertEquals("text/css", mimeType);
    }*/

    /**
     * application/xml
     * @throws IOException
     * @throws HttpRequestException
     */
    @Test
    public void testMimeTypeTextXML() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/app.xml").getPath();
        String mimeType = getMimeType(path);
        Assert.assertEquals("application/xml", mimeType);
    }
    /**
     * Unknown filetype
     * @throws IOException
     * @throws HttpRequestException
     */
    @Test
    public void testUnknownMimeType() throws IOException, HttpRequestException {
        String path = MimeTypeDetectorTest.class.getResource("/filetypes/bb.brb").getPath();
        String mimeType = getMimeType(path);
        Assert.assertEquals("application/octet-stream", mimeType);
    }
}
