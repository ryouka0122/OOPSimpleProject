package jp.co.arsware.oopsample;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import jp.co.arsware.oopsample.dialogs.FileDialog;
import jp.co.arsware.oopsample.events.FileDialogEvent;
import jp.co.arsware.oopsample.shapes.Circle;
import jp.co.arsware.oopsample.shapes.NullShape;
import jp.co.arsware.oopsample.shapes.Shape;
import jp.co.arsware.oopsample.shapes.ShapeType;
import jp.co.arsware.oopsample.shapes.Square;
import jp.co.arsware.oopsample.shapes.Triangle;

public class OOPSimpleProject extends JFrame {

	/** ボタン配置用パネル */
	JPanel pnlButtons;

	/** キャンバス配置用パネル */
	JPanel pnlCanvas;

	/** 削除用ボタン */
	JButton btnClear;

	/** 読み込み用ボタン */
	JButton btnLoad;

	/** 保存用ボタン */
	JButton btnSave;

	/** 円生成用ボタン */
	JButton btnCircle;

	/** 四角形生成用ボタン */
	JButton btnSquare;

	/**三角形生成用ボタン */
	JButton btnTriangle;

	/** キャンバス */
	MyCanvas canvas;

	/** 読み込んだファイルパス */
	String loadFilePath;

	FileDialog fileDialog;

	Random random = new Random(System.currentTimeMillis());

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
		// ダイアログの初期化
		fileDialog = new FileDialog(this);


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

		// 読み込みボタン
		btnLoad = new JButton("Load");
		btnLoad.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		pnlButtons.add(btnLoad);
		btnLoad.addActionListener(
			new FileDialogEvent(FileDialogEvent.EventMode.OpenMode, this, canvas)
		);

		// 保存ボタン
		btnSave = new JButton("Save");
		btnSave.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		pnlButtons.add(btnSave);
		btnSave.addActionListener(
			new FileDialogEvent(FileDialogEvent.EventMode.SaveMode, this, canvas)
		);

		// 円作成ボタン
		btnCircle = new JButton("Circle");
		btnCircle.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		pnlButtons.add(btnCircle);
		btnCircle.addActionListener(new ActionListener() {
			// 円作成ボタン押下イベント
			@Override
			public void actionPerformed(ActionEvent e) {
				// 円オブジェクトの生成
				Shape circle = generateShape(ShapeType.CIRCLE);

				// 図形オブジェクトを設定
				canvas.addShape(circle);

				// キャンバスを再描画
				canvas.repaint();
			}
		});

		// 四角形作成ボタン
		btnSquare = new JButton("Square");
		btnSquare.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		pnlButtons.add(btnSquare);
		btnSquare.addActionListener(new ActionListener() {
			// 四角形作成ボタン押下イベント
			@Override
			public void actionPerformed(ActionEvent e) {
				// 四角形オブジェクトの生成
				Shape square = generateShape(ShapeType.SQUARE);

				// 図形オブジェクトを設定
				canvas.addShape(square);

				// キャンバスを再描画
				canvas.repaint();
			}
		});

		// 三角形作成ボタン
		btnTriangle = new JButton("Triangle");
		btnTriangle.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		pnlButtons.add(btnTriangle);
		btnTriangle.addActionListener(new ActionListener() {
			// 三角形作成ボタン押下イベント
			@Override
			public void actionPerformed(ActionEvent e) {
				// 三角形オブジェクトの生成
				Shape triangle = generateShape(ShapeType.TRIANGLE);

				// 図形オブジェクトを設定
				canvas.addShape(triangle);

				// キャンバスを再描画
				canvas.repaint();

			}
		});

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
		return getRandomValue(0, maxValue);
	}

	/**
	 * 引数の値の間をランダムに返すメソッド
	 * @param maxValue
	 * @return
	 */
	private int getRandomValue(int minValue, int maxValue) {
		if(minValue>maxValue) {
			// swap values
			int tmp = minValue;
			minValue = maxValue;
			maxValue = tmp;
		}
		// calculate random value between minValue and maxValue.
		int value = (int)(Math.random()*Integer.MAX_VALUE);
		return minValue + (value % (maxValue-minValue+1));
	}

	/**
	 * 図形の生成
	 * @param type
	 */
	private Shape generateShape(ShapeType type) {
		if(type==null) return new NullShape();

		Shape shape;
		switch(type) {
		case CIRCLE:
			shape = new Circle();
			break;
		case SQUARE:
			shape = new Square();
			break;
		case TRIANGLE:
			shape = new Triangle();
			break;
		default:
			shape = new NullShape();
		}

		// 場所の設定
		int x = getRandomValue(500);
		int y = getRandomValue(500);
		shape.setPosition(x, y);

		// サイズの設定
		int width = getRandomValue(100, 300);
		int height = getRandomValue(100, 300);
		shape.setSize(width, height);

		// カラーの設定
		int r = getRandomValue(0, 255);
		int g = getRandomValue(0, 255);
		int b = getRandomValue(0, 255);
		shape.setColor(new Color(r,g,b));

		return shape;
	}


	/**
	 * エントリポイント
	 * @param args 実行時引数
	 */
	public static void main(String[] args) {
		new OOPSimpleProject();
	}

}
