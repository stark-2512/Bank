import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;


class sarjb implements ActionListener
{
	String sta;
	String sacc="";
	int acno;
	Frame fls,fsu,fl,psu,fh,fw,ph,fd,ftr,fcb,fs;
	Label lsl1,lsl2,sul1,sul2,sul3,sul4,sul5,psul1,ll1,ll2,wl1,phl1,dl1,trl1,trl2,cbl1,sl1;
	Button lsb1,lsb2,sub1,sub2,psub1,lb1,lb2,hb1,hb2,hb3,hb4,hb5,hb6,hb7,hb8,hb9,wb1,wb2,phb1,db1,db2,trb1,trb2,cbb1,sb1;
	TextField sut1,sut2,sut3,sut4,sut5,lt1,lt2,wt1,dt1,trt1,trt2;
	Panel sup1,sup2,hp1;
	TextArea ta;
	Connection co;
	PreparedStatement ps;
	ResultSet rs;
	sarjb()
	{
		//Connection Setup
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				co=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root",null);

			}catch(Exception e)
			{
				System.out.print("");
			}
		}
		//1st Frame
		{
		fls=new Frame("SARJ Bank");
		lsl2=new Label("SARJ Bank");
		lsl1=new Label("Welcome!!");
		lsb1=new Button("Login");
		lsb2=new Button("Sign Up");
		lsl1.setFont(new Font("Segoe UI", 1, 24));
		lsl2.setFont(new Font("Segoe UI", 1, 24));
		lsb1.setFont(new Font("Times New Roman", 0, 22));
		lsb2.setFont(new Font("Times New Roman", 0, 22));
		fls.setBackground(new Color(204, 204, 204));
		
		fls.add(lsl1);
		fls.add(lsl2);
		fls.add(lsb1);
		fls.add(lsb2);
		fls.setLayout(null);
		
		lsl1.setBounds(150,30,400,50);
		lsl2.setBounds(150,80,400,50);
		lsb1.setBounds(80,160,300,40);
		lsb2.setBounds(80,240,300,40);
		
		lsb1.addActionListener(this);
		lsb2.addActionListener(this);
		
		fls.setSize(470,320);
		fls.setVisible(true);
		}
		//2nd Frame Sign Up
		{
			fsu=new Frame("Sign Up");
			sup1=new Panel();
			sup2=new Panel();
			sul1=new Label("Name");
			sul2=new Label("Age");
			sul3=new Label("Mobile No.");
			sul4=new Label("Amount");
			sul5=new Label("Set Pin");
			sut1=new TextField();
			sut2=new TextField();
			sut3=new TextField();
			sut4=new TextField();
			sut5=new TextField();
			sub1=new Button("Confirm");
			sub2=new Button("Back");
			
			fsu.setLayout(null);
			sup1.setLayout(new GridLayout(5,0,0,10));
			sup2.setLayout(new GridLayout(5,0,0,25));
			
			fsu.add(sup1);
			fsu.add(sup2);
			fsu.add(sub1);
			fsu.add(sub2);
			sup1.add(sul1);
			sup1.add(sul2);
			sup1.add(sul3);
			sup1.add(sul4);
			sup1.add(sul5);
			sup2.add(sut1);
			sup2.add(sut2);
			sup2.add(sut3);
			sup2.add(sut4);
			sup2.add(sut5);
			
			sup1.setBounds(30,40,150,300);
			sup2.setBounds(200,40,220,300);
			sub1.setBounds(80,360,130,40);
			sub2.setBounds(260,360,130,40);
			
			sut5.addActionListener(this);
    	    sut5.setEchoChar('*');
			
			sul1.setFont(new Font("Times New Roman", 1, 20));
			sul2.setFont(new Font("Times New Roman", 1, 20));
			sul3.setFont(new Font("Times New Roman", 1, 20));
			sul4.setFont(new Font("Times New Roman", 1, 20));
			sul5.setFont(new Font("Times New Roman", 1, 20));
			sut1.setFont(new Font("Times New Roman", 0, 20));
			sut2.setFont(new Font("Times New Roman", 0, 20));
			sut3.setFont(new Font("Times New Roman", 0, 20));
			sut4.setFont(new Font("Times New Roman", 0, 20));
			sut5.setFont(new Font("Times New Roman", 0, 20));
			sub1.setFont(new Font("Times New Roman", 1, 20));
			sub2.setFont(new Font("Times New Roman", 1, 20));
			
			
			sub1.addActionListener(this);
			sub2.addActionListener(this);
			fsu.setSize(460,440);
			fsu.setBackground(new Color(204, 204, 204));
			
			//POP UP
			psu=new Frame("Info");
			psul1=new Label("");
			psub1=new Button("OK");
			
			psu.add(psul1);
			psu.add(psub1);
			
			psu.setLayout(null);
			psu.setSize(700,200);
			psul1.setBounds(40,40,620,30);
			psub1.setBounds(250,130,100,30);
			
			psub1.addActionListener(this);	
			psu.setBackground(new Color(204, 204, 204));
			psul1.setFont(new Font("Times New Roman", 1, 20));
			psub1.setFont(new Font("Times New Roman", 1, 20));	
		}
		//3rd Frame Login
		{
			fl=new Frame("Login");
			ll1=new Label("Acc No.");
			ll2=new Label("Password");
			lb1=new Button("OK");
			lb2=new Button("Back");
			lt1=new TextField();
			lt2=new TextField();
			
			fl.add(ll1);
			fl.add(ll2);
			fl.add(lb1);
			fl.add(lb2);
			fl.add(lt1);
			fl.add(lt2);
			
			lt2.addActionListener(this);
    	    lt2.setEchoChar('*');
			
			lb1.addActionListener(this);
			lb2.addActionListener(this);
			
			ll1.setFont(new Font("Times New Roman", 1, 20));
			ll2.setFont(new Font("Times New Roman", 1, 20));
			lt1.setFont(new Font("Times New Roman", 0, 20));
			lt2.setFont(new Font("Times New Roman", 0, 20));
			lb1.setFont(new Font("Times New Roman", 1, 20));
			lb2.setFont(new Font("Times New Roman", 1, 20));
			
			fl.setLayout(null);
			
			ll1.setBounds(40,60,100,30);
			ll2.setBounds(40,120,100,30);
			lt1.setBounds(170,60,200,30);
			lt2.setBounds(170,120,200,30);
			lb1.setBounds(70,180,100,30);
			lb2.setBounds(220,180,100,30);
			
			fl.setSize(400,250);
			fl.setBackground(new Color(204, 204, 204));
		}
		//4th Frame Home
		{
			fh=new Frame("Home");
			hp1=new Panel();
			hb1=new Button("Withdraw");
			hb2=new Button("Deposit");
			hb3=new Button("Transfer");
			hb4=new Button("Check Balance");
			hb5=new Button("Log Out");
			hb6=new Button("Deactivate");
			hb7=new Button("Activate");
			hb8=new Button("Suspend Acc.");
			hb9=new Button("Statement");
			
			hb1.addActionListener(this);
			hb2.addActionListener(this);
			hb3.addActionListener(this);
			hb4.addActionListener(this);
			hb5.addActionListener(this);
			hb6.addActionListener(this);
			hb7.addActionListener(this);
			hb8.addActionListener(this);
			hb9.addActionListener(this);
			
			fh.setLayout(null);
			hp1.setLayout(new GridLayout(9,0,0,20));
			hb1.setFont(new Font("Times New Roman", 1, 20));
			hb2.setFont(new Font("Times New Roman", 1, 20));
			hb3.setFont(new Font("Times New Roman", 1, 20));
			hb4.setFont(new Font("Times New Roman", 1, 20));
			hb5.setFont(new Font("Times New Roman", 1, 20));
			hb6.setFont(new Font("Times New Roman", 1, 20));
			hb7.setFont(new Font("Times New Roman", 1, 20));
			hb8.setFont(new Font("Times New Roman", 1, 20));
			hb9.setFont(new Font("Times New Roman", 1, 20));
			
			fh.add(hp1);
			hp1.add(hb1);
			hp1.add(hb2);
			hp1.add(hb3);
			hp1.add(hb4);
			hp1.add(hb9);
			hp1.add(hb6);
			hp1.add(hb7);
			hp1.add(hb8);
			hp1.add(hb5);
			
			fh.setBackground(new Color(204, 204, 204));
			hp1.setBackground(new Color(204, 204, 204));
			hp1.setBounds(40,55,400,450);
			fh.setSize(500,550);
			
			 
		}
		//5th Frame Withdraw
		{
			fw=new Frame();
			wb1=new Button("OK");
			wb2=new Button("Back");
			wt1=new TextField();
			wl1=new Label("Amount you want to WITHDRAW");
			
			fw.add(wt1);
			fw.add(wl1);
			fw.add(wb1);
			fw.add(wb2);
			wb1.setFont(new Font("Times New Roman", 1, 20));
			wb2.setFont(new Font("Times New Roman", 1, 20));
			wt1.setFont(new Font("Times New Roman", 1, 20));
			wl1.setFont(new Font("Times New Roman", 1, 20));
			
			fw.setLayout(null);
			fw.setBackground(new Color(204,204,204));
			wl1.setBounds(40,40,390,30);
			wt1.setBounds(40,90,390,30);
			wb1.setBounds(100,140,80,30);
			wb2.setBounds(210,140,80,30);
			fw.setSize(450,200);
			wb1.addActionListener(this);
			wb2.addActionListener(this);
			
			
		}
		//POP Up Home
		{
			//POP UP
			ph=new Frame("Info");
			phl1=new Label("");
			phb1=new Button("OK");
			
			ph.add(phl1);
			ph.add(phb1);
			
			ph.setLayout(null);
			ph.setSize(700,200);
			phl1.setBounds(40,40,620,30);
			phb1.setBounds(250,130,100,30);
			
			phb1.addActionListener(this);	
			ph.setBackground(new Color(204, 204, 204));
			phl1.setFont(new Font("Times New Roman", 1, 20));
			phb1.setFont(new Font("Times New Roman", 1, 20));	
	
		}
		//6th Frame Deposit
		{
			fd=new Frame();
			db1=new Button("OK");
			db2=new Button("Back");
			dt1=new TextField();
			dl1=new Label("Amount you want to DEPOSIT");
			
			fd.add(dt1);
			fd.add(dl1);
			fd.add(db1);
			fd.add(db2);
			db1.setFont(new Font("Times New Roman", 1, 20));
			db2.setFont(new Font("Times New Roman", 1, 20));
			dt1.setFont(new Font("Times New Roman", 1, 20));
			dl1.setFont(new Font("Times New Roman", 1, 20));
			
			fd.setLayout(null);
			fd.setBackground(new Color(204,204,204));
			dl1.setBounds(40,40,390,30);
			dt1.setBounds(40,90,390,30);
			db1.setBounds(100,140,80,30);
			db2.setBounds(210,140,80,30);
			fd.setSize(450,200);
			db1.addActionListener(this);
			db2.addActionListener(this);
			
			
			
		}
		//7th Frame Transfer
		{
			ftr=new Frame();
			trb1=new Button("OK");
			trb2=new Button("Back");
			trt1=new TextField();
			trt2=new TextField();
			trl2=new Label("Amount you want to TRANSFER");
			trl1=new Label("To which Account : ");
			
			ftr.add(trt1);
			ftr.add(trt2);
			ftr.add(trl1);
			ftr.add(trl2);
			ftr.add(trb1);
			ftr.add(trb2);
			trb1.setFont(new Font("Times New Roman", 1, 20));
			trb2.setFont(new Font("Times New Roman", 1, 20));
			trt1.setFont(new Font("Times New Roman", 1, 20));
			trt2.setFont(new Font("Times New Roman", 1, 20));
			trl1.setFont(new Font("Times New Roman", 1, 20));
			trl2.setFont(new Font("Times New Roman", 1, 20));
			
			ftr.setLayout(null);
			ftr.setSize(500,280);
			
			ftr.setBackground(new Color(204,204,204));
			trl1.setBounds(40,40,200,30);
			trt1.setBounds(270,40,200,30);
			trl2.setBounds(40,100,390,30);
			trt2.setBounds(40,150,430,30);
			trb1.setBounds(100,210,80,30);
			trb2.setBounds(210,210,80,30);
			
			trb1.addActionListener(this);
			trb2.addActionListener(this);
		}
		//8th Frame Check Balance
		{
			//POP UP
			fcb=new Frame("Info");
			cbl1=new Label("");
			cbb1=new Button("OK");
			
			fcb.add(cbl1);
			fcb.add(cbb1);
			
			fcb.setLayout(null);
			fcb.setSize(700,200);
			cbl1.setBounds(40,40,620,30);
			cbb1.setBounds(250,130,100,30);
			
			cbb1.addActionListener(this);	
			fcb.setBackground(new Color(204, 204, 204));
			cbl1.setFont(new Font("Times New Roman", 1, 20));
			cbb1.setFont(new Font("Times New Roman", 1, 20));
		}
		//9th Frame Statement
		{
			fs=new Frame("Statement");
			ta=new TextArea();
			sl1=new Label("Statement");
			sb1=new Button("OK");
			
			fs.add(ta);
			fs.add(sl1);
			fs.add(sb1);
			
			fs.setBackground(new Color(204, 204, 204));
			sl1.setFont(new Font("Times New Roman", 1, 26));
			sb1.setFont(new Font("Times New Roman", 1, 20));
			
			fs.setLayout(null);
			fs.setSize(500,620);
			
			sl1.setBounds(40,40,150,50);
			ta.setBounds(40,120,420,400);
			sb1.setBounds(150,560,80,30);
			
			sb1.addActionListener(this);
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==lsb2)
		{
			fls.setVisible(false);
			fsu.setVisible(true);
		}
		else if(e.getSource()==lsb1)
		{
			fl.setVisible(true);
			fls.setVisible(false);
		}
		else if(e.getSource()==sub1)
		{
			try
			{
			int acc;
			String acno = "";
			ps=co.prepareStatement("select max(ACNo) from details");
			rs=ps.executeQuery();
			while(rs.next())
			{
				acno=acno+rs.getString(1);
			}
			acc=Integer.parseInt(acno);
			ps.close();
			rs.close();
			
			acc=acc+1;
			
			String s2=sut1.getText();
			String s3=sut2.getText();
			String s4=sut3.getText();
			String s5=sut4.getText();
			String s6=sut5.getText();
			
			
			ps=co.prepareStatement("insert into details(ACNo,Name,Age,Mobile,Balance,Password) values(?,?,?,?,?,?)"); 
			ps.setInt(1,acc);
			ps.setString(2,s2);
			ps.setInt(3,Integer.parseInt(s3));
			ps.setString(4,s4);
			ps.setInt(5,Integer.parseInt(s5));
			ps.setInt(6,Integer.parseInt(s6));
			ps.executeUpdate();
			ps.close();
			
			sut1.setText("");
			sut2.setText("");
			sut3.setText("");
			sut4.setText("");
			sut5.setText("");
			psu.setVisible(true);
			psul1.setText("Account Created Successfully and your Account No. is : " + acc);
			}catch(Exception ee)
			{
				System.out.print("Save  "+ee);
			}
			
			
		}
		else if(e.getSource()==sub2)
		{
			fsu.setVisible(false);
			fls.setVisible(true);
		}
		else if(e.getSource()==psub1)
		{
			psu.setVisible(false);
			fsu.setVisible(false);
			fls.setVisible(true);
			fl.setVisible(false);
			fw.setVisible(false);
		}
		else if(e.getSource()==lb1)
		{
			try
			{
			sacc=lt1.getText();
			String s1=lt1.getText();
			String s2=lt2.getText();
			ps=co.prepareStatement("Select * from details where ACNo=? and Password=?");
			ps.setString(1,s1);
			ps.setString(2,s2);
			rs=ps.executeQuery();
			if(rs.next())
			{
				ps=co.prepareStatement("select Status from details where ACNo=?");
				ps.setString(1,sacc);
				rs=ps.executeQuery();
				while(rs.next())
				{
					sta=rs.getString(1);
				}
				
				if(sta.equals("A"))
				{
					fl.setVisible(false);
					fh.setVisible(true);
				}
				else if(sta.equals("D"))
				{
					fl.setVisible(false);
					fh.setVisible(true);
					
				}
				else
				{
					psul1.setText("Account is Suspended.....You can't access the account!!");
					psu.setVisible(true);
				}
				
			}
			else 
			{
				psul1.setText("Invalid Password or Account No.");
				psu.setVisible(true);
			}
		
			ps.close();
			lt1.setText("");
			lt2.setText("");
			
			
			}catch(Exception ee)
			{
				System.out.print("Save  "+ee);
			}
	    
		
		}
		else if(e.getSource()==lb2)
		{
			lt1.setText("");
			lt2.setText("");
			fl.setVisible(false);
			fls.setVisible(true);	
		}
		else if(e.getSource()==hb1)
		{
			if(sta.equals("A"))
			{
			fh.setVisible(false);
			fw.setVisible(true);
			}
			else
			{
				phl1.setText("Account is Deactivated");
				ph.setVisible(true);
			}
		}
		else if(e.getSource()==hb2)
		{
			
			if(sta.equals("A"))
			{
			fh.setVisible(false);
			fd.setVisible(true);
			}
			else
			{
				phl1.setText("Account is Deactivated");
				ph.setVisible(true);
			}
		}
		else if(e.getSource()==hb3)
		{
			fh.setVisible(false);
			ftr.setVisible(true);
			if(sta.equals("A"))
			{
			fh.setVisible(false);
			ftr.setVisible(true);
			}
			else
			{
				phl1.setText("Account is Deactivated");
				ph.setVisible(true);
			}
		}
		else if(e.getSource()==hb4)
		{
			fcb.setVisible(true);
			try
			{
			int bal;
			String s2="";
			ps=co.prepareStatement("Select Balance from details where ACNo=?");
				ps.setInt(1,Integer.parseInt(sacc));
				rs=ps.executeQuery();
				while(rs.next())
				{
					s2=s2+rs.getString(1);
				}
				ps.close();
				rs.close();
				bal=Integer.parseInt(s2);
				cbl1.setText("Your Balance is : "+ bal);
				
			}catch(Exception ee)
			{
				System.out.print("Check bal  "+ee);
			}
			
		}
		else if(e.getSource()==hb5)
		{
			fls.setVisible(true);
			fh.setVisible(false);
		}
		else if(e.getSource()==hb6)
		{
			try
			{
			if(sta.equals("A"))
			{
				ps=co.prepareStatement("update details set Status='D' where ACNo=?");
				ps.setString(1,sacc);
				ps.executeUpdate();
				ps.close();
				sta="D";
				phl1.setText("Account Deactivated...... ");
				ph.setVisible(true);
			
			}
		
			else
			{
				phl1.setText("Account is already Deactivated");
				ph.setVisible(true);
			}
			}catch(Exception ee)
			{
				System.out.print("hb6"+ee);
			}
		}
		else if(e.getSource()==hb7)
		{
			try
			{
			if(sta.equals("D"))
			{
				ps=co.prepareStatement("update details set Status='A' where ACNo=?");
				ps.setString(1,sacc);
				ps.executeUpdate();
				ps.close();
				sta="A";
				phl1.setText("Account Activated...... ");
				ph.setVisible(true);
			}
		
			else
			{
				phl1.setText("Account is already Activated");
				ph.setVisible(true);
			}
			}catch(Exception ee)
			{
				System.out.print("hb7"+ee);
			}
		}
		else if(e.getSource()==hb8)
		{
			try
			{
			if(sta.equals("A"))
			{
				ps=co.prepareStatement("update details set Status='S' where ACNo=?");
				ps.setString(1,sacc);
				ps.executeUpdate();
				ps.close();
				sta="S";
				fls.setVisible(true);
				fh.setVisible(false);
				
			}
		
			else
			{
				ps=co.prepareStatement("update details set Status='S' where ACNo=?");
				ps.setString(1,sacc);
				ps.executeUpdate();
				ps.close();
			
				sta="S";
				fls.setVisible(true);
				fh.setVisible(false);
			}
			}catch(Exception ee)
			{
				System.out.print("hb8"+ee);
			}
		}
		else if(e.getSource()==hb9)
		{
			try
			{
				String a="\n | Acc No |\n";
				String date=" Date |\n";
				String des="\n Description |\n";
				String d="\n Deposits |\n";
				String w="\n Withdrawals |\n";
				String r="\n Refrence |\n";
				String b="\n Balance |\n";
				
				if(sta.equals("A"))
				{
					ps=co.prepareStatement("select * from statement where ACNo=?");
					ps.setInt(1,Integer.parseInt(sacc));
					rs=ps.executeQuery();
					while(rs.next())
					{
						a=a+rs.getString(1)+"\n";
						date=date+rs.getString(2)+"\n";
						des=des+rs.getString(3)+"\n";
						d=d+rs.getString(4)+"\n";
						w=w+rs.getString(5)+"\n";
						r=r+rs.getString(6)+"\n";
						b=b+rs.getString(7)+"\n";
						
					}
					
					ps.close();
					rs.close();
					
					
					
					ta.setText(a+"  "+date+"  "+des+"  "+d+"  "+w+"  "+r+"  "+b+"  ");
					
					fs.setVisible(true);
					fh.setVisible(false);
				}
				else
				{
				}
			}catch(Exception ee)
			{
				System.out.print("Statement" +ee);
			}				
		}
		else if(e.getSource()==phb1)
		{
			ph.setVisible(false);
			fw.setVisible(false);
			fd.setVisible(false);
			fh.setVisible(true);
			ftr.setVisible(false);
		}
		else if(e.getSource()==wb1)
		{

			try 
			{
				int wa,bal,nbal;
				String s2="";
				String s1=wt1.getText();
				wa=Integer.parseInt(s1);
				ps=co.prepareStatement("Select Balance from details where ACNo=?");
				ps.setInt(1,Integer.parseInt(sacc));
				rs=ps.executeQuery();
				while(rs.next())
				{
					s2=s2+rs.getString(1);
				}
				ps.close();
				rs.close();
				bal=Integer.parseInt(s2);
				
				nbal=bal-wa;
				if(nbal<500)
				{
					phl1.setText("Balance should not drop less than 500");
					ph.setVisible(true);
				}
				else
				{
					try
					{
					ph.setVisible(true);
					phl1.setText("Money Withdrawn Your new Balance is : "+ nbal);
					
					
					ps=co.prepareStatement("update details set Balance=? where ACNo=?");
					ps.setInt(1,nbal);
					ps.setInt(2,Integer.parseInt(sacc));
					ps.executeUpdate();
					ps.close();				
					
										
					String da="";				
					ps=co.prepareStatement("select curdate()");
					rs=ps.executeQuery();
					while(rs.next())
					{
						da=da+rs.getString(1);
					}
					ps.close();
					rs.close();
					
					Date da1=Date.valueOf(da);
					
					ps=co.prepareStatement("insert into statement (ACNo,Date,Description,Withdrawals,Balance) values (?,?,?,?,?)");
					ps.setInt(1,Integer.parseInt(sacc));
					ps.setDate(2,da1);
					ps.setString(3,"Withdrawal");
					ps.setInt(4,wa);
					ps.setInt(5,nbal);
					ps.executeUpdate();
					ps.close();
					}catch(Exception ef)
					{
						System.out.print("Andr error h" + ef);
					}
					
				}
				
				wt1.setText("");
				
				
				
			}catch(Exception ee)
			{
				System.out.print("Withdraw"+ee);
			}
			
		}
		else if(e.getSource()==wb2)
		{
			fw.setVisible(false);
			fh.setVisible(true);
			wt1.setText("");
		}
		else if(e.getSource()==db1)
		{
			try 
			{
				int da,bal,nbal;
				String s2="";
				String s1=dt1.getText();
				da=Integer.parseInt(s1);
				ps=co.prepareStatement("Select Balance from details where ACNo=?");
				ps.setInt(1,Integer.parseInt(sacc));
				rs=ps.executeQuery();
				while(rs.next())
				{
					s2=s2+rs.getString(1);
				}
				ps.close();
				rs.close();
				bal=Integer.parseInt(s2);
				
				nbal=bal+da;
				ph.setVisible(true);
				phl1.setText("Money Deposited Your new Balance is : "+ nbal);
				
				
				ps=co.prepareStatement("update details set Balance=? where ACNo=?");
				ps.setInt(1,nbal);
				ps.setInt(2,Integer.parseInt(sacc));
				ps.executeUpdate();
				ps.close();
				
				String da2="";				
					ps=co.prepareStatement("select curdate()");
					rs=ps.executeQuery();
					while(rs.next())
					{
						da2=da2+rs.getString(1);
					}
					ps.close();
					rs.close();
					
					Date da1=Date.valueOf(da2);
					
					ps=co.prepareStatement("insert into statement (ACNo,Date,Description,Deposits,Balance) values (?,?,?,?,?)");
					ps.setInt(1,Integer.parseInt(sacc));
					ps.setDate(2,da1);
					ps.setString(3,"Deposit");
					ps.setInt(4,da);
					ps.setInt(5,nbal);
					ps.executeUpdate();
					ps.close();
				
				dt1.setText("");
			}catch(Exception ee)
			{
				System.out.print("Deposit"+ee);
			}
	
		}
		else if(e.getSource()==db2)
		{
			fw.setVisible(false);
			fh.setVisible(true);
			dt1.setText("");
		}
		else if(e.getSource()==trb1)
		{
			try 
			{
				
				int ta,tabal,bal,nbal;
				String s4="";
				String s3=trt1.getText();
				String s2="";
				String s1=trt2.getText();
				ta=Integer.parseInt(s1);
				ps=co.prepareStatement("Select Balance from details where ACNo=?");
				ps.setInt(1,Integer.parseInt(sacc));
				rs=ps.executeQuery();
				while(rs.next())
				{
					s2=s2+rs.getString(1);
				}
				ps.close();
				rs.close();
				bal=Integer.parseInt(s2);	
				ps=co.prepareStatement("Select Balance from details where ACNo=?");
				ps.setInt(1,Integer.parseInt(s3));
				rs=ps.executeQuery();
				while(rs.next())
				{
					s4=s4+rs.getString(1);
				}
				ps.close();
				rs.close();
				tabal=Integer.parseInt(s4);				
				
				
				nbal=bal-ta;
				if(nbal<500)
				{
					phl1.setText("Balance should not drop less than 500");
					ph.setVisible(true);
				}
				else
				{
					tabal=tabal+ta;
					ph.setVisible(true);
					phl1.setText("Money Transferred Your new Balance is : "+ nbal);
					
					ps=co.prepareStatement("update details set Balance=? where ACNo=?");
					ps.setInt(1,nbal);
					ps.setInt(2,Integer.parseInt(sacc));
					ps.executeUpdate();
					ps.close();
				
					ps=co.prepareStatement("update details set Balance=? where ACNo=?");
					ps.setInt(1,tabal);
					ps.setInt(2,Integer.parseInt(s3));
					ps.executeUpdate();
					ps.close();
					
					String da="";				
					ps=co.prepareStatement("select curdate()");
					rs=ps.executeQuery();
					while(rs.next())
					{
						da=da+rs.getString(1);
					}
					ps.close();
					rs.close();
					
					Date da1=Date.valueOf(da);
					
					ps=co.prepareStatement("insert into statement (ACNo,Date,Description,Withdrawals,Refrence,Balance) values (?,?,?,?,?,?)");
					ps.setInt(1,Integer.parseInt(sacc));
					ps.setDate(2,da1);
					ps.setString(3,"Transferred");
					ps.setInt(4,ta);
					ps.setInt(5,Integer.parseInt(s3));
					ps.setInt(6,nbal);
					ps.executeUpdate();
					ps.close();
					
					ps=co.prepareStatement("insert into statement (ACNo,Date,Description,Deposits,Refrence,Balance) values (?,?,?,?,?,?)");
					ps.setInt(1,Integer.parseInt(s3));
					ps.setDate(2,da1);
					ps.setString(3,"Transferred");
					ps.setInt(4,ta);
					ps.setInt(5,Integer.parseInt(sacc));
					ps.setInt(6,tabal);
					ps.executeUpdate();
					ps.close();
				}
				trt1.setText("");
				trt2.setText("");
				
			}catch(Exception ee)
			{
				trt1.setText("Account Doesn't Exist");
				System.out.print("Deposit"+ee);
			}
	
		}
		else if(e.getSource()==trb2)
		{
			ftr.setVisible(false);
			fh.setVisible(true);
			trt1.setText("");
			trt2.setText("");
		}
		else if(e.getSource()==cbb1)
		{
			fcb.setVisible(false);
			fh.setVisible(true);
		}
	}
	
	
	public static void main(String ar[])
	{
		sarjb s1=new sarjb();
	}
}	
	
