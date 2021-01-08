package FileDemo.fileFilter;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auther Lucas
 * @date 2019/1/6 22:27
 * 自定义过滤器
 * 实现FileFilter接口
 */
public class myFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        Pattern p = Pattern.compile("^(judge).*");
        Matcher m = p.matcher(pathname.getName());
        return m.matches();
    }

}
