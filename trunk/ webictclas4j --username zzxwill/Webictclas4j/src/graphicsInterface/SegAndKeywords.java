package graphicsInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

import keywords.GetKeywords;

public class SegAndKeywords extends JPanel {
	static final int WIDTH = 500;
	static final int HEIGHT = 300;
	JFrame textInputFrame;
	String inputText;

	public void add(Component c, GridBagConstraints constraints, int x, int y,
			int w, int h) {
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		add(c, constraints);

	}

	public SegAndKeywords() throws FileNotFoundException {
		textInputFrame = new JFrame("������Ƶ�������ݼ������ı���������");
		textInputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout lay = new GridBagLayout();
		setLayout(lay);
		textInputFrame.add(this, BorderLayout.NORTH);
		textInputFrame.setSize(WIDTH, HEIGHT);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		int x = (width - WIDTH) / 2;
		int y = (height - HEIGHT) / 2;
		textInputFrame.setLocation(x, y);

		JButton search = new JButton("����");
		JLabel note1 = new JLabel("��������Ƶ�����ı�");
		JTextField text = new JTextField(36);
//		JLabel nullNote = new JLabel("");

		// textInputFrame.setLayout(new BorderLayout(30,13));

		JPanel p1 = new JPanel();

		/*
		 * ���÷ִʺ͹ؼ�����ȡ ��ʾ���
		 */
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();

		// System.out.println();

		p1.setLayout(new BorderLayout(1, 1));
		p2.setLayout(new BorderLayout(0, 0));
		p3.setLayout(new BorderLayout(0, 0));
		p1.setVisible(true);
		p2.setVisible(true);
		p3.setVisible(true);
		p1.add(note1, "North");
		p1.add(search, "East");
//		p1.add(nullNote, "West");
		p1.add(text, "Center");
//		p1.add(nullNote, "South");


		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.weightx = 3;
		constraints.weighty = 4;
		// add(note1, constraints, 0, 1, 1, 1);
		// add(text, constraints, 0, 2, 1, 1);
		// add(search, constraints, 1, 2, 1, 1);

		/*
		 * System.out.println("��ȡ�ִʵ����ս��:\n" +wordSegResult + "\n");
		 */
		// System.out.println("��ȡ�ִʵ����ս��:\n" +wordSegResult + "\n");
		GetKeywords key = new GetKeywords();
		key.getKeywordsMain4GUI("���˼�����������ҽ�����");
		String str1 =null;
		JLabel none = new JLabel(str1);
		JLabel segResult1 = new JLabel("�ִʽ��:");
		JLabel segResult2 = new JLabel("���˼����/nr ����/n ��/f ��/f ����/v ");

		JLabel keyResult1 = new JLabel("�ؼ��ʷ������:\n");
		JLabel keyResult2 = new JLabel("�˶�Ա�����˼����");
		JLabel keyResult3 = new JLabel("������-������������");
		JLabel keyResult5 = new JLabel("���岿λ-�ҽţ��ҽ�");

		JLabel keyResult4 = new JLabel("����-������Ա����-���ţ�����");

		p2.add(segResult1, "North");
		p2.add(segResult2, "West");

		p3.add(keyResult1, "North");
		p3.add(keyResult2, "West");
		p3.add(keyResult3, "Center");
		p3.add(keyResult4, "East");

		add(p1, constraints, 0, 0, 1, 1);
	
		

//		add(note1, constraints, 1, 1, 1, 1);
//		add(text, constraints, 1, 2, 1, 1);
//		add(search,constraints, 2, 2, 1, 1);
		
		
		

		
//		add(none, constraints, 1, 9, 1, 1);

		add(segResult1, constraints, 1, 10, 1, 1);
		

		add(segResult2, constraints, 1, 11, 1, 1);


//		add(p2, constraints, 1, 6, 1, 1);
	

		add(keyResult1, constraints, 1, 20, 1, 1);
		add(keyResult2, constraints, 1, 21, 1, 1);

		add(keyResult3, constraints, 1, 22, 1, 1);

		add(keyResult4, constraints, 1, 23, 1, 1);
		add(keyResult5, constraints, 1, 24, 1, 1);

		// add(p3, constraints, 0, 3, 0, 1);

		// add(segResult1,constraints, 0, 1, 0, 1);
		// add(segResult2,constraints, 0, 2, 0, 1);

		// textInputFrame.setVisible(false);
		textInputFrame.setVisible(true);

		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// inputText = text.getText();
				// System.out.println("�û��������Ƶ�����ı��ǣ�" + inputText);

				// try {
				// key.getKeywordsMain4GUI(inputText);
				// } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				// }

				/*
				 * ��ʾ����Ľ��
				 */
				// JOptionPane.showMessageDialog(null, "OK");
				new OutputVedio2();
				// new OutputVedio2();

			}
		});

	}
}

// public class OutputVedio {
// public static void main(String args[]) {
// new ShowVedio();

// }

// }
