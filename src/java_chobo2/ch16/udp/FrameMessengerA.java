package java_chobo2.ch16.udp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class FrameMessengerA extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;

	DatagramSocket socket;
	DatagramPacket packet;
	InetAddress address = null;
	
	final int myPort = 5000; 
	final int otherPort = 6000; 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMessengerA frame = new FrameMessengerA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrameMessengerA() {
		setTitle("MessengerA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		textField = new JTextField(30);
		textField.addActionListener(this);

		textArea = new JTextArea(10, 30);
		textArea.setEditable(false);

		contentPane.add(textField, BorderLayout.SOUTH);
		contentPane.add(textArea, BorderLayout.CENTER);
		
		try {
			address = InetAddress.getByName("127.0.0.1");
			socket = new DatagramSocket(myPort);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		Messenger_Thread th = new Messenger_Thread();
		th.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = textField.getText();
		byte[] buffer = s.getBytes();
		DatagramPacket packet;

		packet = new DatagramPacket(buffer, buffer.length, address, otherPort);
		try {
			socket.send(packet);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		textArea.append("SENT: " + s + "\n");
		textField.selectAll();
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}

	class Messenger_Thread extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					byte[] buf = new byte[256];
					packet = new DatagramPacket(buf, buf.length);
					socket.receive(packet); 
					textArea.append("RECIEVED: " + new String(buf) + "\n");
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
		}
	}
}
