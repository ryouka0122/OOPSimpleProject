package jp.co.arsware.oopsample.events;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import jp.co.arsware.oopsample.MyCanvas;
import jp.co.arsware.oopsample.dialogs.FileDialog;

/**
 * ファイル選択ダイアログ表示イベント
 * @author ryouka0122@github
 *
 */
public class FileDialogEvent extends ButtonEvent {

	/**
	 * イベントの種類
	 * @author ryouka0122@github
	 *
	 */
	public enum EventMode {
		OpenMode {
			@Override
			public boolean showDialog(FileDialog fd) {
				return fd.showOpenDialog();
			}

			@Override
			public void invokeCanvas(MyCanvas canvas, File file) throws IOException {
				canvas.loadFile(file);
			}
		}
		,SaveMode {
			@Override
			public boolean showDialog(FileDialog fd) {
				return fd.showSaveDialog();
			}

			@Override
			public void invokeCanvas(MyCanvas canvas, File file) throws IOException {
				canvas.saveFile(file);
			}
		}
		;
		abstract public boolean showDialog(FileDialog fd);
		abstract public void invokeCanvas(MyCanvas canvas, File file) throws IOException;
	}


	private EventMode mode;

	private MyCanvas canvas;

	private FileDialog fileDialog;

	/**
	 * コンストラクタ
	 * @param parent
	 */
	public FileDialogEvent(EventMode mode, Frame parent, MyCanvas canvas) {
		super(parent);
		this.mode = mode;
		this.canvas = canvas;
		this.fileDialog = new FileDialog(parent);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(mode.showDialog(this.fileDialog)) {
				mode.invokeCanvas(this.canvas, this.fileDialog.getSelectedPath());
				this.canvas.repaint();
			}
		} catch (IOException ex) {
			// 例外処理
			JOptionPane.showMessageDialog(null, ex);
		}
	}

}
