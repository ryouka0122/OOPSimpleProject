package jp.co.arsware.oopsample.shapes;

import java.awt.Graphics;

/**
 * 三角形オブジェクト
 * @author ryouka0122@github
 *
 */
public class Triangle extends Shape {

	/**
	 * 描画
	 * @param g
	 */
	@Override
	public void render(Graphics g) {
		g.setColor(surfaceColor);
		// 描画は▲のイメージ

		int ptX[] = new int[3];
		int ptY[] = new int[3];

		// 頂点座標の設定
		ptX[0] = posX + width / 2;
		ptY[0] = posY;
		ptX[1] = posX + width;
		ptY[1] = posY + height;
		ptX[2] = posX;
		ptY[2] = posY + height;

		// 描画
		g.fillPolygon(ptX, ptY, 3);
	}

	@Override
	public boolean hittest(int canvasPosX, int canvasPosY) {
		int[] ptX = new int[3];
		int[] ptY = new int[3];

		// 頂点座標の設定
		ptX[0] = posX + width / 2;
		ptY[0] = posY;
		ptX[1] = posX + width;
		ptY[1] = posY + height;
		ptX[2] = posX;
		ptY[2] = posY + height;

		/** 実装中
		HitTestResult result = isContains(canvasPosX, canvasPosY, ptX, ptY, 3);
		return (result==HitTestResult.ONBOUNDS || result==HitTestResult.INSIDE);
		 */
		return false;
	}

	/**
	 * ヒットテスト結果
	 * @author ryouka0122@github
	 *
	 */
	enum HitTestResult {
		ONBOUNDS, 	// 境界線上
		INSIDE,		// 境界線より内側
		OUTSIDE;	// 境界線より外側
	};

	/**
	 * 多角形の内外判定
	 * @param x 判定する点のX座標
	 * @param y 判定する点のY座標
	 * @param ptX 多角形の頂点のX座標配列
	 * @param ptY 多角形の頂点のY座標配列
	 * @param nVertex 多角形の頂点数
	 * @return 内側のとき
	 */
	private HitTestResult isContains(int x, int y, int[] ptX, int[] ptY, int nVertex) {
		// 判定用変数
		int nDirSign = 0;

		// 辺上にあるときの判定
		int onBounds = 0;

		// 各頂点を中心に計算する
		for(int i=0 ; i<nVertex ; i++) {
			int j = (i+1) % nVertex;
			// 次の頂点までのベクトル（辺）
			int vx = ptX[j] - ptX[i];
			int vy = ptY[j] - ptY[i];
			// 判定する頂点までのベクトル
			int px = x - ptX[i];
			int py = y - ptY[i];

			// 辺と点の位置関係を内積で計算
			int theta = vx * px + vy * py;

			if(theta == 0) {
				// 0のときは点が辺上にある
				onBounds += 1;
			}else if(theta > 0) {
				// 正の数のとき加算
				nDirSign += 1;
			}else{
				// 負の数のとき減算
				nDirSign -= 1;
			}
		}

		// 負数を正数に変換
		if(nDirSign<0) {
			nDirSign *= -1;
		}

		// 境界線上判定
		if(onBounds > 0 && (onBounds+nDirSign)==nVertex) {
			return HitTestResult.ONBOUNDS;
		}

		// 頂点数より少ない時外側
		if(nDirSign<nVertex) {
			return HitTestResult.OUTSIDE;
		}else{
			return HitTestResult.INSIDE;
		}



		/*
		// 各辺のベクトル
		int v1x = ptX[0]-ptX[2],
			v1y = ptY[0]-ptY[2],
			v2x = ptX[1]-ptX[0],
			v2y = ptY[1]-ptY[0],
			v3x = ptX[2]-ptX[1],
			v3y = ptY[2]-ptY[1];

		// 各頂点から判定座標に向けてのベクトル
		int p1x = x-ptX[2],
			p1y = y-ptY[2],
			p2x = x-ptX[0],
			p2y = y-ptY[0],
			p3x = x-ptX[1],
			p3y = y-ptY[1];

		// 判定値の計算（ベクトルの内積を使って，左右判定値を生成）
		int theta1 = v1x * p1x + v1y * p1y;
		int theta2 = v2x * p2x + v2y * p2y;
		int theta3 = v3x * p3x + v3y * p3y;

		//内外判定
		if(theta1<0 && theta2<0 && theta3<0) {
			// すべての符号が同じ時，内側
			return HitTestResult.INSIDE;
		}else if(theta1>0 && theta2>0 && theta3>0) {
			// すべての符号が同じ時，内側
			return HitTestResult.INSIDE;
		}else if(theta1==0 || theta2==0 || theta3==0) {
			// いずれかが0のとき境界線上
			return HitTestResult.ONBOUNDS;
		}else{
			// 上記を満たさない場合，外側
			return HitTestResult.OUTSIDE;
		}
		*/
	}




}
