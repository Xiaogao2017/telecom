package com.tc.producer.io;

import com.tc.common.bean.Data;
import com.tc.common.bean.DataIn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr. Li xiaogao 2020-05-29 20:43
 * 本地文件数据输入
 */
public class LocalFileDataIn implements DataIn {
    //增加数据流
    private BufferedReader reader = null;
    public LocalFileDataIn(String path) {
        setPath(path);
    }

    @Override
    public void setPath(String path) {
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object read() throws IOException {
        return null;
    }

    /**
     * 读取数据，返回数据集合
     * @param cla
     * @param <T>
     * @return
     * @throws IOException
     */
    @Override
    public <T extends Data> List<T> read(Class<T> cla) throws IOException {
        List<T> ts = new ArrayList<T>();
        //从数据文件中读取所有的数据
        String line = null;
        while ((line = reader.readLine() )!= null){
            //将数据转换为指定类型的对象，封装为集合返回
            try {
                T t = cla.newInstance();
                t.setValue(line);
                ts.add(t);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return ts;
    }

    /**
     * 关闭资源
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        if (reader != null){
            reader.close();
        }
    }
}
