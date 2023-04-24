package test;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.activation.*;
public class sendEmail {
           public static void main(String[] args) throws InterruptedException {
        	/*   String hostname="localhost";
        	   String from="3415676398@qq.com";
        	   String to="3415676398@qq.com";
        	   String shouquanma="bxginmdxqplmdaig";
        	   String text="你好";
        	   new sendEmailByQQSmpt().send(hostname, from, to, shouquanma, text);
        	   */
        	   new sendEmailGUI();
        	   }
}
class sendEmailByQQSmpt{
	public void send(String hostname,String from,String to,String shouquanma,String text) throws InterruptedException {
	
	Properties properties=System.getProperties();
	
      properties.put("mail.transport.protocol", "smtp");// 连接协议
      properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
     

	Session session=Session.getDefaultInstance(properties);
	MimeMessage message = new MimeMessage(session);
	try {
		message.setSubject("subject line");
		message.setText(text);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(to));
		Transport transport = session.getTransport();
		transport.connect(from, shouquanma);
		transport.sendMessage(message, message.getAllRecipients());
	} catch (MessagingException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	}
}
class sendEmailGUI extends JFrame{
	private Container container;
	private JFrame jframe=new JFrame();
	private JTextField from=new JTextField("from");
	private JTextField to=new JTextField("to");
	private JTextField id=new JTextField("id");
	private JTextField text=new JTextField("text");
	private JButton send=new JButton("发送邮件");
	sendEmailGUI(){
		jframe=new JFrame();
		container=jframe.getContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200,300,800,100);
		setLayout(new GridLayout());
		
		from.setSize(100,20);
		to.setSize(100,20);
		id.setSize(30,10);
		text.setSize(50,50);
		send.setSize(50,50);
		send.setBackground(Color.green);
		
		add(from);
		add(to);
		add(id);
		add(text);
		add(send);
		setVisible(true);
		
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				try {
					new sendEmailByQQSmpt().send("localhost", from.getText(), to.getText(), id.getText(), text.getText());
				} catch (InterruptedException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		
	}
}