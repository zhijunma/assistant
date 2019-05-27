package java.com.cn.assistant.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;


public class GetAppURLService
{
    public GetAppURLService(File f) throws Exception
    {
        parse(f);
    }

    private boolean is_dir;

    public boolean isDirectory()
    {
        return is_dir;
    }

    private String real_file;

    public String getRealFilename()
    {
        return real_file;
    }

    public void parse(File f) throws Exception
    {
        // read the entire file into a byte buffer
        FileInputStream fin = new FileInputStream(f);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        byte[] buff = new byte[256];
        while (true)
        {
            int n = fin.read(buff);
            if (n == -1)
            {
                break;
            }
            bout.write(buff, 0, n);
        }
        fin.close();
        byte[] link = bout.toByteArray();

        // get the flags byte
        byte flags = link[0x14];

        // get the file attributes byte
        final int file_atts_offset = 0x18;
        byte fileatts = link[file_atts_offset];
        byte is_dir_mask = (byte) 0x10;
        if ((fileatts & is_dir_mask) > 0)
        {
            is_dir = true;
        } else
        {
            is_dir = false;
        }

        // if the shell settings are present, skip them
        final int shell_offset = 0x4c;
        int shell_len = 0;
        if ((flags & 0x1) > 0)
        {
            // the plus 2 accounts for the length marker itself
            shell_len = bytes2short(link, shell_offset) + 2;
        }

        // get to the file settings
        int file_start = 0x4c + shell_len;

        // get the local volume and local system values
        int local_sys_off = link[file_start + 0x10] + file_start;
        real_file = getNullDelimitedString(link, local_sys_off);
        p("real filename = " + real_file);
    }

    static String getNullDelimitedString(byte[] bytes, int off)
    {
        int len = 0;
        // count bytes until the null character (0)
        while (true)
        {
            if (bytes[off + len] == 0)
            {
                break;
            }
            len++;
        }
        return new String(bytes, off, len);
    }

    static int bytes2short(byte[] bytes, int off)
    {
        return (bytes[off] & 0xFF) | ((bytes[off + 1] & 0xFF) << 8) ;
    }
    public static void p(String str)
    {
        System.out.println(str);
    }

    public static void main(String[] args) throws Exception
    {
        new GetAppURLService(new File("C:\\Users\\Administrator\\Desktop\\"+"%有道词典%"+".lnk"));
    }
}