package jp.co.arsware.oopsample.dialogs;

import java.awt.Frame;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class FileDialog {

	/** 所有コンポーネント */
	Frame parent;

	/** ファイル選択ダイアログ */
	JFileChooser chooser;

	public FileDialog(Frame parent) {
		this.chooser = new JFileChooser();
		this.parent = parent;

		// CSVファイルの未選択できるように制御
		this.chooser.setFileFilter( new FileFilter() {

			@Override
			public String getDescription() {
				return "CSVファイル(*.csv)";
			}

			@Override
			public boolean accept(File f) {
				if(f.isDirectory()) return true;

				String filename = f.getName();
				int pos = filename.lastIndexOf('.');
				if(pos<0) {
					return false;
				}
				return "csv".equals(filename.substring(pos+1));
			}
		});
	}

	/**
	 * 読み込み用ダイアログの表示
	 * @return
	 */
	public boolean showOpenDialog() {
		return (this.chooser.showOpenDialog(parent)==JFileChooser.APPROVE_OPTION);
	}

	/**
	 * 保存用ダイアログの表示
	 * @return
	 */
	public boolean showSaveDialog() {
		return (this.chooser.showSaveDialog(parent)==JFileChooser.APPROVE_OPTION);
	}

	/**
	 * 選択したファイルの取得
	 * @return
	 */
	public File getSelectedPath() {
		return this.chooser.getSelectedFile();
	}



}
