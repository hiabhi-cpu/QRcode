package cameraRead;
//main camera reader check successful
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import dataBaseconn.InsertIntoDB;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.apache.log4j.PropertyConfigurator;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.time.LocalDateTime;

public class QRCodeReader {

    private static final int WEBCAM_INDEX = 0;
    private static final int WEBCAM_WIDTH = 640;
    private static final int WEBCAM_HEIGHT = 480;
    private final Action action_5 = new SwingAction_5();
    Webcam webcam;
    JFrame window;
    private static final Executor EXECUTOR = Executors.newSingleThreadExecutor();
    
    public QRCodeReader(){
    	PropertyConfigurator.configure("log4j.properties");
        webcam = Webcam.getWebcams().get(WEBCAM_INDEX);
        webcam.setViewSize(WebcamResolution.VGA.getSize());

        JPanel panel3 = new WebcamPanel(webcam);
        panel3.setPreferredSize(WebcamResolution.VGA.getSize());

        // Add the webcam panel to a JFrame to display the video feed
        window = new JFrame("QR Code Reader");
        window.setSize(100, 100);
        window.add(panel3);
        window.pack();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setAction(action_5);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(187, 169, 179, 35);
		
        
        EXECUTOR.execute(() -> {
        	JFrame frame1=new JFrame("Welcome");
        	frame1.setBounds(200, 200, 300, 300);
        	JLabel label=new JLabel("Hello");
        	label.setBounds(100,100,200,200);
        	label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        	label.setHorizontalAlignment(SwingConstants.CENTER);
        	frame1.add(label);
            while (true) {
                try {
                    BufferedImage image = webcam.getImage();
                    LuminanceSource source = new BufferedImageLuminanceSource(image);
                    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                    Result result = new MultiFormatReader().decode(bitmap);
                    String text = result.getText();
                    System.out.println("Decoded QR code: " + text+"   "+LocalDateTime.now().getSecond());
                    InsertIntoDB intoDB= new InsertIntoDB(text);
                    label.setText(text+" "+intoDB.getFlaString());
                    frame1.setVisible(true);
                    Thread.sleep(3000);
                    frame1.setVisible(false);
                } catch (Exception e) {
                    // No QR code was found in the image
                }
            }
        });
        window.add(btnNewButton_1_1);
    }

    public static void main(String[] args) {
    	new QRCodeReader();
    }
    private class SwingAction_5 extends AbstractAction {	//start session
		public SwingAction_5() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("Start session");
			webcam.close();
			window.setVisible(false);
		}
	}
}

