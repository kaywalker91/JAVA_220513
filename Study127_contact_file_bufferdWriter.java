package study0513;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import java.util.Vector;

public class Study127_contact_file_bufferdWriter {
	public static void main(String[] args)  {
		Friendss f = new Friendss();
	}
}
class Friendss{
	Scanner sc = new Scanner(System.in);
	int MAX=100;//�� ���尡���� �ο��� ����
	
	//�̸� ���� ��°� ����ó �迭...
	String name[]= new String[MAX];
	String age[]= new String[MAX];
	String addr[]= new String[MAX];
	String hp[]= new String[MAX];
	String saveData[] = new String[MAX];
	int cnt=0; //ģ���� �߰��Ҷ����� ��ϵ� �ο��� üũ.
	int select;
	
	
	File dir = new File("c:\\aaa\\work");
	File file = new File(dir, "test.dat");		
	
	Friendss() 
	{

		while(true)
		{
			menu();
			if(select == 1)      {input();}
			else if(select == 2) {output();}			
			else if(select == 3) {fileSaveAll();}
			else if(select == 4) {break;}
		}
		System.out.println("���α׷�����..");
		
	}
	
	void output()
	{
        try{
            //���� ��ü ����
            File file = new File("C:\\aaa\\work\\data.txt");
            //�Է� ��Ʈ�� ����
            FileReader filereader = new FileReader(file);
            //�Է� ���� ����
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            int i = 0;
            while((line = bufReader.readLine()) != null){
                System.out.println(line);
                
                saveData[i] = line;//���پ��о�ö� ������� ���ʴ�� �����ϱ�
                i++;
            }                 
            bufReader.close();
        }catch (FileNotFoundException e) {           
        }catch(IOException e){           
        }
		

	}
	void input()
	{
		System.out.print("�̸�:"); name[cnt] = sc.next();
		System.out.print("����:"); age[cnt] = sc.next();
		System.out.print("��°�:"); addr[cnt] = sc.next();
		System.out.print("����ó:"); hp[cnt] = sc.next();
				
		System.out.println("ģ�� �Ѹ� ��� �Ϸ�!");
		
		saveData[cnt] = name[cnt]+"/"+age[cnt]+"/"+addr[cnt]+"/"+hp[cnt];
		
		System.out.println("saveData["+cnt+"]:"+saveData[cnt]);
		fileSaveOne(saveData[cnt]);//���پ� �����ϱ�
		
		cnt++; //�Ѹ� �Է³������Ƿ� ��������Է��ϱ����� ����.	
	}
	void menu()
	{
		System.out.println("1.ģ�����");
		System.out.println("2.ģ������");
		System.out.println("3.�����ϱ�(�ϰ�)");
		System.out.println("4.����");
		System.out.print("����:"); select = sc.nextInt();
	}
	//���پ������ϱ�.
		void fileSaveOne(String data)
		{
			 try{
		            //���� ��ü ����
		            File file = new File("C:\\aaa\\work\\data.txt");
		            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
		            
		            if(file.isFile() && file.canWrite()){            

		                bufferedWriter.write(data);
		                bufferedWriter.newLine();
		                bufferedWriter.close();
		            }
		        }catch (IOException e) {
		            System.out.println(e);
		        }
		}
		
	//�ѹ��������ϱ�
	void fileSaveAll()
	{
		 try{
	            //���� ��ü ����
	            File file = new File("C:\\aaa\\work\\data.txt");
	            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
	            
	            if(file.isFile() && file.canWrite()){
                
	                for(int i=0; i<cnt; i++ )
	                {
	                	bufferedWriter.write(saveData[i]);
	                	bufferedWriter.newLine();
	                }                
	                
	                bufferedWriter.close();
	            }
	        }catch (IOException e) {
	            System.out.println(e);
	        }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}