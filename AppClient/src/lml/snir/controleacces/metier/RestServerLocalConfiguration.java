/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.metier;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import lml.rest.client.RestServerConfig;

/**
 *
 * @author alan
 */
public class RestServerLocalConfiguration extends RestServerConfig {

    private static String url = "http://localhost:9999";

    static {
        FileInputStream in = null;
        try {
            Properties prop = new Properties();
            in = new FileInputStream("server.properties");
            prop.load(in);
            in.close();
            url = prop.getProperty("server.url");
        } catch (IOException e) {
            System.err.println(e.getMessage() + "\nusing default url : " + url);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public RestServerLocalConfiguration() {
        super(url, "MiniProject", "rest");
    }

}
