package com.leapfrog.springFramework.Utility;
import com.leapfrog.springFramework.DAO.FileHandlerDAO;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author BkoNod
 */
@Repository(value = "fileHandlerDAO")
public class FileHandler implements FileHandlerDAO {
    
    @Override
    public String uploadFile(String title,String pathName, MultipartFile file)
    {
    
       if (!file.isEmpty()) {
            try {
              byte[] bytes = file.getBytes();
              String filename=file.getOriginalFilename();
                          

                // Creating the directory to store file
              String rootPath = System.getProperty("catalina.home");
              File dir = new File(rootPath + File.separator + "Documents"+ File.separator + pathName);
              if (!dir.exists()) {
                    dir.mkdirs();
                }

                // Create the file on server
              File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + filename);
              BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
              stream.write(bytes);
              String filePath=serverFile.getAbsolutePath();
              System.out.println(filePath);
              return filePath;
            } catch (Exception exception) {
              System.out.println(exception.getMessage());
            }
    }
       
    return null;
    }
    
   public void downloadFile() throws FileNotFoundException
    {}

    @Override
    public String uploadImage(MultipartFile file) {
        try {
            int IMG_WIDTH = 900;
            int IMG_HEIGHT = 900;
            String filename=file.getOriginalFilename();
            BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
            int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
            BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
            g.dispose();
            g.setComposite(AlphaComposite.Src);
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.setRenderingHint(RenderingHints.KEY_RENDERING,
            RenderingHints.VALUE_RENDER_QUALITY);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
            
            String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "images"+ File.separator + "userDp");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
               String filePath=dir.getPath()+"\\"+filename;
               ImageIO.write(resizedImage, "jpg", new File(filePath));
               return filePath;

        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
}
