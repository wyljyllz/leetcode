package wei.io;

import java.io.*;

/**
 * @ClassName StreamTest
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class StreamTest {
    public static void newFileTest() {
        boolean flag = false;
        String path = "D:\\desk\\学习文件\\niaho.txt";
        File file = new File(path);
        if (!file.exists()) {
            try {
                flag = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(flag ? "新建成功" : "新建失败");

        }
    }
    /**
     * @description:读取文件内容
     * @author: 卫依伦
     * @date: 2021/10/2
     */
    public static void testFileRead() {
        FileReader fr = null;
        try {
            File file = new File("D:\\desk\\学习文件\\hello.txt");
            fr = new FileReader(file);
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                String s = new String(cbuf, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * @description:将内容写入文件
     * @author: 卫依伦
     * @date: 2021/10/2
     */
    public static void testFileWriter() {
        FileWriter fw = null;
        try {
            File file = new File("D:\\desk\\学习文件\\hello.txt");
            fw = new FileWriter(file, true);
            fw.write("i have a dream你好");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * @description:对文本进行复制
     * @author: 卫依伦
     * @date: 2021/10/2
     */
    public static void testFileReadFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File scrFile = new File("D:\\desk\\学习文件\\hello.txt");
            File destFile = new File("D:\\desk\\学习文件\\nihao.txt");
            fr = new FileReader(scrFile);
            fw = new FileWriter(destFile);
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * @description:对文件进行复制
     * @author: 卫依伦
     * @date: 2021/10/2
     */
    public static void testFileInputOutputStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File scrFile = new File("D:\\desk\\学习文件\\pho.jpg");
            File destFile = new File("D:\\desk\\学习文件\\wei.jpg");
            fis = new FileInputStream(scrFile);
            fos = new FileOutputStream(destFile);
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer,0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null)
                try {
                    fos.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        testFileInputOutputStream();
        //testFileReadFileWriter();
        //testFileWriter();
        //testFileRead();
    }
}

