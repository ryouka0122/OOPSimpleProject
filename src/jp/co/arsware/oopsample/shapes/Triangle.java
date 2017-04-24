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

		HitTestResult result = isContains(canvasPosX, canvasPosY, ptX, ptY, 3);
		return (result==HitTestResult.ONBOUNDS || result==HitTestResult.INSIDE);

		//return false;
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
		int nDirPositive = 0;
		int nDirNegative = 0;
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

			// 辺と点の位置関係を外積で計算
			int theta = vx * py - vy * px;

			if(theta == 0) {
				// 0のときは点が辺上にある
				onBounds += 1;
			}else if(theta > 0) {
				// 正の数のとき
				nDirPositive += 1;
			}else{
				// 負の数のとき
				nDirNegative += 1;
			}
		}

		// 境界線上判定
		if(onBounds > 0) {
			if( (nDirPositive-nDirNegative)==nVertex ) {
				return HitTestResult.ONBOUNDS;
			}else{
				return HitTestResult.OUTSIDE;
			}
		}else{
			// 頂点数より少ない時外側
			if( nDirPositive == 0 || nDirNegative == 0 ) {
				return HitTestResult.INSIDE;
			}else{
				return HitTestResult.OUTSIDE;
			}
		}
	}

}
