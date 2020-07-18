package com.tc.producer.io;

import com.tc.common.bean.DataOut;

import java.io.*;

/**
 * @author Mr. Li xiaogao 2020-05-29 20:44
 * 本地文件的数据输出
 */
public class LocalFileDataOut implements DataOut {

    private PrintWriter writer = null;

    public LocalFileDataOut(String path) {
        setPath(path);
    }

    @Override
    public void setPath(String path) {
        try {
            writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(Object data) throws Exception {
        write(data.toString());
    }

    /**
     * 将数据字符串生成到文件中
     * @param data
     * @throws Exception
     */
    @Override
    public void write(String data) throws Exception {
        writer.println(data);
        //将流中数据之间放进文件中
        writer.flush();
    }

    @Override
    public void close() throws IOException {
        if (writer != null){
            writer.close();
        }
    }
}
