package qrTrying;

public class Write_Class_Try {

	public Write_Class_Try(String str) {
		// TODO Auto-generated constructor stub
		//to create a QRcode by passing string as an argument
		String filePath = "C:\\Users\\Reddy\\OneDrive\\Documents\\javaqr\\";
		String fileNameString=str;
		Create_QR qr=new Create_QR();
		qr.writeFun(fileNameString,filePath+"jeeva"+".png");
	}
	
	public static void main(String args[]) {
		new Write_Class_Try("https://drive.google.com/file/d/1UuQkfVWhfkeAqyvlOBPUWN6M1L5gNwob/view?usp=drivesdk");
	}
}
