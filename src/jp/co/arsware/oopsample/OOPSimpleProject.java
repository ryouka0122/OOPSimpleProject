package jp.co.arsware.oopsample;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import jp.co.arsware.oopsample.shapes.Circle;
import jp.co.arsware.oopsample.shapes.Shape;
import jp.co.arsware.oopsample.shapes.Square;
import jp.co.arsware.oopsample.shapes.Triangle;

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
		btnCircle.addActionListener(new ActionListener() {
			// 円作成ボタン押下イベント
			@Override
			public void actionPerformed(ActionEvent e) {
				// 円オブジェクトの生成
				Circle circle = new Circle();

				// 初期化と追加
				setShape(circle);

				// キャンバスを再描画
				canvas.repaint();
			}
		});
		pnlButtons.add(btnCircle);

		// 四角形作成ボタン
		btnSquare = new JButton("Square");
		btnSquare.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		btnSquare.addActionListener(new ActionListener() {
			// 四角形作成ボタン押下イベント
			@Override
			public void actionPerformed(ActionEvent e) {
				// 四角形オブジェクトの生成
				Square square = new Square();

				// 初期化と追加
				setShape(square);

				// キャンバスを再描画
				canvas.repaint();
			}
		});
		pnlButtons.add(btnSquare);

		// 三角形作成ボタン
		btnSquare = new JButton("Triangle");
		btnSquare.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		btnSquare.addActionListener(new ActionListener() {
			// 三角形作成ボタン押下イベント
			@Override
			public void actionPerformed(ActionEvent e) {
				// 三角形オブジェクトの生成
				Triangle triangle = new Triangle();

				// 初期化と追加
				setShape(triangle);

				// キャンバスを再描画
				canvas.repaint();
			}
		});
		pnlButtons.add(btnSquare);

		// ------------------------------------------------
		// キャンバスの生成
		canvas = new MyCanvas();
		canvas.setSize(500, 500);
		canvas.setBackground(Color.WHITE);	// 背景を白にする
		pnlCanvas.add(canvas);	// パネルに配置

		// ------------------------------------------------
		// ウィンドウのサイズの設定
		getContentPane().setPreferredSize(new Dimension(700, 500));		// ウィンドウの内側のサイズを指定
		pack();	// ウィンドウ自体のサイズは自動調整

		// ------------------------------------------------
		// ウィンドウの表示
		setVisible(true);
	}

	/**
	 * 0から引数の値までの間をランダムに返すメソッド
	 * @param maxValue
	 * @return
	 */
	private int getRandomValue(int maxValue) {
		return (int)(Math.random()*maxValue);
	}

	/**
	 * 図形の初期化とキャンバスへの追加
	 * @param shape
	 */
	private void setShape(Shape shape) {

		// 場所の設定
		int x = getRandomValue(500);
		int y = getRandomValue(500);
		shape.setPosition(x, y);

		// サイズの設定
		int width = getRandomValue(300);
		int height = getRandomValue(300);
		shape.setSize(width, height);

		// カラーの設定
		int r = getRandomValue(256);
		int g = getRandomValue(256);
		int b = getRandomValue(256);
		shape.setColor(new Color(r,g,b));

		// 図形オブジェクトを設定
		canvas.addShape(shape);
	}

	/**
	 * エントリポイント
	 * @param args 実行時引数
	 */
	public static void main(String[] args) {
		new OOPSimpleProject();
	}

}
