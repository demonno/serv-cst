package edu.cst.webserver.http;

import edu.cst.webserver.uri.Resource;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * User: vaxop
 */
public class HttpDirFilesList {
    File file;

    public HttpDirFilesList(File file) {
        this.file = file;
    }

    public String getDirList() {
        File[] fileItems = file.listFiles();
        
        String basePath = file.getName();
        StringBuilder builder = new StringBuilder();

        builder.append("<html>");
        builder.append("<head>");
        builder.append("<style TYPE=\"text/css\">");
        builder.append("<!-- *{margin: 5px; padding: 5px;}");
        builder.append("header,section,left_side, middle_side,right_side{ display: block;}");
        builder.append("body{text-align: left;}");
        builder.append("h1{font: 25 px bold;}");
        builder.append("#head{border-bottom: 1px solid grey; height: 40px;}");
        builder.append("#titles{font :20 px bold;}");
        builder.append("#link{font :15 px bold;}-->");
        builder.append("</style>");
        builder.append("</head>");
        builder.append("<body>");
        builder.append("<header id=\"head\">");
        builder.append("<h1>Index of C:\\server\\build\\node_modules\\</h1>");
        builder.append("</header>");
        builder.append("<table width=\"500\">");
        builder.append("<tr id=\"titles\">");
        builder.append("<td>Name</td>");
        builder.append("<td>Size</td>");
        builder.append("<td>Date Modified</td>");
        builder.append("</tr>");
        builder.append("<tr>");
        builder.append("<td>");
        builder.append("<a href=\""+ basePath + "\">backTest</a>");
        builder.append("</td>");
        builder.append("</tr>");
        for (File file : fileItems) {
            builder.append("<tr id=\"link\">");
            builder.append("<td><a href=\"");
            builder.append(basePath);
            builder.append("\\");
            builder.append(file.getName());
            builder.append("\" >");
            if (file.isDirectory()) {
                builder.append("/");
            }
            builder.append(file.getName());
            builder.append("</a></td>");
            builder.append("<td>3 KB</td>");
            builder.append("<td>12/21/12</td>");
            builder.append("</tr>");
        }

        builder.append("</table>");
        builder.append("</section>");
        builder.append("</body>");
        builder.append("</html>");

        return builder.toString();
    }
}