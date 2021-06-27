/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adsi;

import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class koneksi 
{
    public Properties mypanel, myLanguage;
    private String strNamPanel;
    public koneksi()
    {
        
    }
    
    public String SettingPanel(String nmPanel)
    {
        try
        {
            mypanel = new Properties();
            mypanel.load(new FileInputStream("lib/database.ini"));
            strNamPanel = mypanel.getProperty(nmPanel);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
            System.err.println(ex.getMessage());
            System.exit(0);
        }
        return strNamPanel;
    }
}
