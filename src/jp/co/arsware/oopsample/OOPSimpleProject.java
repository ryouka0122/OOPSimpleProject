package jp.co.arsware.oopsample;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import jp.co.arsware.oopsample.factories.CircleFactory;
import jp.co.arsware.oopsample.factories.ImageFactory;
import jp.co.arsware.oopsample.factories.SquareFactory;
import jp.co.arsware.oopsample.factories.TriangleFactory;

public class OOPSimpleProject extends JFrame {

	/** ボタン配置用パネル */
	JPanel pnlButtons;

	/** キャンバス配置用パネル */
	JPanel pnlCanvas;

	/** 削除用ボタン */
	JButton btnClear;

	/** 円生成用ボタン */
	JButton btnCircle;

	/** 四角形生成用ボタン */
	JButton btnSquare;

	/** キャンバス */
	MyCanvas canvas;

	/**
	 * コンストラクタ
	 */
	public OOPSimpleProject() {
		super();
		// ------------------------------------------------
		// ウィンドウのタイトル設定
		setTitle("OOP体験型サンプルプログラム");

		// [x]を押したときの挙動をデフォルト設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ------------------------------------------------
		// ウィンドウのレイアウトを無効化する
		setLayout(null);

		// ------------------------------------------------
		// パネルの生成と配置

		// ボタン用パネル
		pnlButtons = new JPanel();
		pnlButtons.setBounds(0, 0, 200, 500);	// ボタンを置く場所と大きさを決める
		BoxLayout layoutButtons = new BoxLayout(pnlButtons, BoxLayout.Y_AXIS);
		pnlButtons.setLayout(layoutButtons);
		// ウィンドウにパネルを配置
		add(pnlButtons);

		// キャンバス用パネル
		pnlCanvas = new JPanel();
		pnlCanvas.setBounds(200, 0, 500, 500);	// キャンバスを置く場所と大きさを決める
		add(pnlCanvas);		// ウィンドウにパネルを配置

		// ------------------------------------------------
		// キャンバスの生成
		canvas = new MyCanvas();
		canvas.setSize(500, 500);
		canvas.setBackground(Color.WHITE);	// 背景を白にする
		pnlCanvas.add(canvas);	// パネルに配置

		// ------------------------------------------------
		// ボタンの生成とパネルへの配置

		// 削除ボタン
		btnClear = new JButton("Clear");
		btnClear.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		pnlButtons.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			// 削除ボタン押下イベント
			@Override
			public void actionPerformed(ActionEvent e) {
				// キャンバスに設定した情報を綺麗にする
				canvas.clear();

				// キャンバス再描画
				canvas.repaint();
			}
		});

		// 円作成ボタン
		btnCircle = new JButton("Circle");
		btnCircle.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		btnCircle.addActionListener(new ButtonActionListener(canvas, new CircleFactory()));
		pnlButtons.add(btnCircle);

		// 四角形作成ボタン
		btnSquare = new JButton("Square");
		btnSquare.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		btnSquare.addActionListener(new ButtonActionListener(canvas, new SquareFactory()));
		pnlButtons.add(btnSquare);

		// 三角形作成ボタン
		btnSquare = new JButton("Triangle");
		btnSquare.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		btnSquare.addActionListener(new ButtonActionListener(canvas, new TriangleFactory()));
		pnlButtons.add(btnSquare);

		// 画像作成ボタン
		btnSquare = new JButton("Image");
		btnSquare.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		btnSquare.addActionListener(new ButtonActionListener(canvas, new ImageFactory(this)));
		pnlButtons.add(btnSquare);


		// ------------------------------------------------
		// ウィンドウのサイズの設定
		getContentPane().setPreferredSize(new Dimension(700, 500));		// ウィンドウの内側のサイズを指定
		pack();	// ウィンドウ自体のサイズは自動調整

		// ------------------------------------------------
		// ウィンドウの表示
		setVisible(true);
	}

	/**
	 * エントリポイント
	 * @param args 実行時引数
	 */
	public static void main(String[] args) {
		new OOPSimpleProject();
	}

}
