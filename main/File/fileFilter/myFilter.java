package File.fileFilter;

import java.io.File;
import java.io.FileFilter;

/**
 * @auther Lucas
 * @date 2019/1/6 22:27
 * 自定义过滤器
 * 实现FileFilter接口
 */
public class myFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return true;
    }
}
