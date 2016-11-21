package com.taorui.tags;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.*;
import java.io.IOException;
import java.io.*;
import java.util.*;
import javax.comm.*;
import javax.swing.*;

import com.taorui.service.HphenService;

public class Chuankou extends JFrame implements ActionListener, SerialPortEventListener {
	HphenService hep;

	public Chuankou() {
		hep = new HphenService();
	}

	private TextArea readTa;
	private JLabel jl1;
	private SerialPort port;
	private JLabel wengdu, wengdu1, shidu, shidu1;
	private JButton jbA1, jbA2;
	protected SerialPort serialPort;
	protected CommPortIdentifier portId;
	protected List<String> portList;
	private JCheckBox checkBox1, checkBox2, checkBox3;
	private Choice choice, choice1, choice2;;
	private JTextField resultText2, resultText3;
	private JTextArea resultText1;
	private JLabel jlabel1, jlabel2, jlabel3, jlabe4, jlabe5, jlabe6;
	protected int sendCount, reciveCount;
	protected OutputStream outputStream = null;
	protected InputStream inputStream = null;
	private String datas1;

	public void Maininterface() {
		this.setTitle("串口");
		Image();
		this.setBounds(600, 600, 455, 455);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			System.exit(0);
		}
	}

	/**
	 * 控件位置
	 */
	private void Image() {
		jl1 = new JLabel();
		Container jp = this.getContentPane();
		Image imge1 = new ImageIcon("").getImage();
		jl1.setIcon(new ImageIcon(imge1));
		jl1.setBounds(0, 0, 455, 565);
		jlabel1 = new JLabel("通讯设置");
		jlabel1.setBounds(10, 10, 70, 40);
		jlabe5 = new JLabel("数据接收");
		jlabe5.setBounds(370, 10, 70, 40);
		jlabel2 = new JLabel("串口号");
		jlabel2.setBounds(40, 40, 50, 40);
		choice = new Choice();
		choice.setBounds(90, 45, 70, 40);
		jlabel3 = new JLabel("波特率");
		jlabel3.setBounds(40, 65, 50, 40);
		choice1 = new Choice();
		choice1.setBounds(90, 75, 70, 40);
		checkBox1 = new JCheckBox("      十六进制显示");
		checkBox1.setBounds(40, 145, 125, 25);
		checkBox2 = new JCheckBox("      十六进制发送");
		checkBox2.setBounds(40, 170, 125, 25);
		jlabe4 = new JLabel("数据位");
		jlabe4.setBounds(40, 90, 50, 40);
		choice2 = new Choice();
		choice2.setBounds(90, 100, 70, 40);
		jbA1 = new JButton("打开串口");
		jbA1.setBounds(60, 230, 100, 30);
		jlabe6 = new JLabel("数据发送");
		jlabe6.setBounds(370, 170, 100, 30);
		readTa = new TextArea("");
		readTa.setFont(new Font("宋体", Font.BOLD, 20));
		readTa.setBounds(170, 50, 270, 120);
		jbA2 = new JButton("发送");
		jbA2.setBounds(60, 270, 100, 30);
		resultText1 = new JTextArea("");
		resultText1.setFont(new Font("宋体", Font.BOLD, 20));
		resultText1.setBounds(170, 200, 270, 100);
		wengdu1 = new JLabel("温度:");
		wengdu1.setFont(new Font("宋体", Font.BOLD, 25));
		wengdu1.setBounds(30, 330, 100, 50);
		wengdu = new JLabel("C°");
		wengdu.setFont(new Font("宋体", Font.BOLD, 25));
		wengdu.setBounds(165, 330, 50, 50);
		resultText2 = new JTextField();
		resultText2.setEditable(false);
		resultText2.setFont(new Font("宋体", Font.BOLD, 20));
		resultText2.setBounds(100, 330, 55, 45);
		shidu = new JLabel("%°");
		shidu.setFont(new Font("宋体", Font.BOLD, 25));
		shidu.setBounds(400, 330, 50, 50);
		shidu1 = new JLabel("湿度:");
		shidu1.setFont(new Font("宋体", Font.BOLD, 25));
		shidu1.setBounds(265, 330, 100, 50);
		resultText3 = new JTextField();
		resultText3.setEditable(false);
		resultText3.setFont(new Font("宋体", Font.BOLD, 20));
		resultText3.setBounds(337, 330, 55, 45);
		checkBox3 = new JCheckBox("       显示温湿度");
		checkBox3.setBounds(40, 195, 115, 25);
		jl1.add(checkBox3);
		jl1.add(resultText3);
		jl1.add(resultText2);
		jl1.add(shidu);
		jl1.add(shidu1);
		jl1.add(wengdu);
		jl1.add(wengdu1);
		jl1.add(jlabel1);
		jl1.add(jlabel2);
		jl1.add(choice);
		jl1.add(choice1);
		jl1.add(jlabel3);
		jl1.add(jlabe4);
		jl1.add(choice2);
		jl1.add(jbA1);
		jl1.add(jlabe6);
		jl1.add(jbA2);
		jl1.add(checkBox1);
		jl1.add(checkBox2);
		jl1.add(jlabe5);
		jl1.add(readTa);
		jl1.add(resultText1);
		jp.add(jl1);
		checkBox1.addActionListener(this);
		checkBox2.addActionListener(this);
		jbA1.addActionListener(this);
		jbA2.addActionListener(this);
		scanPorts();
	}

	/**
	 * 1、串口打开 把串口打开
	 */
	@SuppressWarnings("restriction")
	public void handBack() throws CloneNotSupportedException {

		String a = jbA1.getText();
		if (a.equals("打开串口")) {
			readTa.append("");
			resultText1.setText("");
			resultText2.setText("");
			readTa.setText("");
			jbA1.setText("关闭串口");
			openSerialPort();// 调用打开方法
		} else {
			port.close();// 关闭
			jbA1.setText("打开串口");
			resultText1.setText("");
			readTa.append("");
			setComponentsEnabled(true);
		}
	}

	/**
	 * 2 、检测串口 检测串口是否存在
	 */
	public void scanPorts() {
		portList = new ArrayList<String>();
		Enumeration<?> en = CommPortIdentifier.getPortIdentifiers();
		CommPortIdentifier portId;
		while (en.hasMoreElements()) {
			portId = (CommPortIdentifier) en.nextElement();
			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				String name = portId.getName();
				if (!portList.contains(name)) {
					choice.add(name);
					portList.add(name);
				}
			}
		}
		choice2.add("8");
		choice1.add("9600");
		if (null == portList || portList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "串口未找到");
		}
	}

	/**
	 * 3、检测串口 检测串口是否存在 <br>
	 * 如果存在对串口参数进行设置 <br>
	 * 端口号：设置COM口的波特率，数据位，停止位，校验位。
	 */
	public void openSerialPort() {
		// 获取需要得到的串口
		try {
			String aString = choice.getSelectedItem().toString();
			portId = CommPortIdentifier.getPortIdentifier(aString);
		} catch (NoSuchPortException e) {
			JOptionPane.showMessageDialog(null, "抱歉,没有找到");
			setComponentsEnabled(true);
			return;
		}
		// 打开端口
		try {
			port = (SerialPort) portId.open("Read", 50);
			JOptionPane.showMessageDialog(null, "端口打开了");
			port.setSerialPortParams(9600, 8, 1, 0);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "端口被占用了！");
			e1.printStackTrace();
		}
		// 打开端口IO流管道
		try {
			outputStream = port.getOutputStream();
			inputStream = port.getInputStream();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "IO打开失败！");
		}
		// 打开端口添加监听器
		try {
			port.addEventListener(this);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "端口监听添加失败！");
		}
		port.notifyOnDataAvailable(true);
	}

	/**
	 * 4、 向串口发送数据
	 */
	private void faSong() {
		if (jbA1.getText().equals("打开串口")) {
			JOptionPane.showMessageDialog(null, "请打开串口");
		} else {
			if (resultText1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "发送区为空");
			} else {
				try {
					sendout("");
					setComponentsEnabled(false);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 5、串口打开数据隐藏
	 */
	public void setComponentsEnabled(boolean enabled) {
		choice.setEnabled(enabled);
		choice2.setEnabled(enabled);
		choice1.setEnabled(enabled);
	}

	/**
	 * 6、发送发送需要为 <br>
	 * 16进制还是字符的算法处理
	 */

	public void sendout(String data) throws IOException {
		int j = 0;
		datas1 = data;
		if (checkBox2.isSelected()) {
			String a = null;
			if ("".equals(data)) {
				a = resultText1.getText();
			} else {
				a = data;
				datas1 = data;
			}
			byte[] as = a.getBytes();
			byte[] asb = new byte[as.length];
			for (int i = 0; i < a.length(); i++) {
				if (as[i] != 32) {
					asb[j] = as[i];
					j++;
				}
			}
			if (j > 0) {
				if (j % 2 == 0) {
					byte[] bs1 = new byte[j / 2];
					int k = 0;
					for (int i = 0; i < j - 1; i = i + 2) {
						bs1[k] = (byte) (hebin(asb[i]) + jisuan(asb[i + 1]));
						k++;
					}
					OutputStream outs = port.getOutputStream();//
					try {
						outs.write(bs1, 0, bs1.length);// 写
					} catch (IOException e) {
						e.printStackTrace();
					}
					outs.close();
				}
			}

		} else {
			try {
				String a = resultText1.getText();
				System.out.println(a);
				byte[] d = a.getBytes("utf-8");
				OutputStream out = port.getOutputStream();
				out.write(d, 0, a.length());// 普通字符写
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public byte hebin(byte a) {
		byte c = 0;
		if (a == 48) {
			c = 0;
		} else if (a == 49) {
			c = (byte) (a - 33);
		} else if (a == 50) {
			c = (byte) (a - 18);
		} else if (a == 51) {
			c = (byte) (a - 3);
		} else if (a == 52) {
			c = (byte) (a + 12);
		} else if (a == 53) {
			c = (byte) (a + 27);
		} else if (a == 54) {
			c = (byte) (a + 42);
		} else if (a == 55) {
			c = (byte) (a + 57);
		} else if (a == 56) {
			c = (byte) (a + 72);
		} else if (a == 57) {
			c = (byte) (a + 87);
		} else if (a == 97) {
			c = (byte) (a + 63);
		} else if (a == 98) {
			c = (byte) (a + 78);
		} else if (a == 99) {
			c = (byte) (a + 93);
		} else if (a == 100) {
			c = (byte) (a + 108);
		} else if (a == 101) {
			c = (byte) (a + 123);
		} else if (a == 102) {
			c = (byte) (a + 138);
		} else if (a == 65) {
			c = (byte) (a + 95);
		} else if (a == 66) {
			c = (byte) (a + 110);
		} else if (a == 67) {
			c = (byte) (a + 125);
		} else if (a == 68) {
			c = (byte) (a + 140);
		} else if (a == 69) {
			c = (byte) (a + 155);
		} else if (a == 70) {
			c = (byte) (a + 170);
		}
		return c;
	}

	public byte jisuan(byte b) {
		byte c = 0;
		if (b >= 48 && b <= 57) {
			c = (byte) (b - 48);
		} else if (b >= 97 && b <= 102) {
			c = (byte) (b - 87);
		} else if (b >= 65 & b <= 70) {
			c = (byte) (b - 55);
		}
		return c;
	}

	/**
	 * @param 7、控件点击进行监听
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jbA1) {
			try {
				setComponentsEnabled(false);
				handBack();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == jbA2) {
			faSong();
		}
	}

	/**
	 * @param 8、SerialPortEvent：端口监听事件
	 */
	@Override
	public void serialEvent(SerialPortEvent event) {
		String as = new String();
		try {
			int count = 0;
			while (count == 0) {
				count = inputStream.available();
			}
			byte[] readBuffer = new byte[count];
			inputStream.read(readBuffer);
			if (checkBox1.isSelected() == false) {
				StringBuilder receivedMsg = new StringBuilder();
				receivedMsg.append(new String(readBuffer).trim()).append("");
				readTa.setText("");
				readTa.append(receivedMsg.toString());
				// System.out.println(datas1);
			} else {
				String[] cs = new String[count];
				int a[] = new int[20];
				for (int i = 0; i < readBuffer.length; i++) {
					a[i] = readBuffer[i];
					as = Integer.toHexString(a[i]);
					if (as.length() == 1) {
						as = "0" + as;
					} else if (as.length() == 8) {
						as = as.substring(6, 8);
					}
					cs[i] = as;
					readTa.setText("");
				}
				as = "";
				for (int i = 0; i < cs.length; i++) {
					as += cs[i];
				}
				readTa.setText("");
				readTa.append(as + " ");
				hep.Hphen(datas1, as);
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}

	public int wendu(int wendu1) {
		if (wendu1 >= 48 && wendu1 <= 57) {
			wendu1 = wendu1 - 48;
		} else if (wendu1 >= 97 && wendu1 <= 102) {
			wendu1 = wendu1 - 87;
		} else {
			wendu1 = 0;
		}
		return wendu1;
	}

	/**
	 * 程序入口
	 */
	public static void main(String[] args) {
		Chuankou aChuankou = new Chuankou();
		aChuankou.Maininterface();
	}

}
