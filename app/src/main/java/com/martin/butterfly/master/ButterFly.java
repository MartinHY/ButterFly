package com.martin.butterfly.master;

import android.graphics.Path;
import android.graphics.Rect;

/**
 * 作者：MartinBZDQSM on 2016/9/2 0002.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 */
public class ButterFly {

    public Path p = new Path();

    private static final float[] VIEW_BOX_512 = {0.000000f, 0.000000f, 512.000000f, 512.000000f};

    // 蝴蝶路径
    protected void butterFlyPathInit(Rect bounds) {
        float viewBoxWidth = VIEW_BOX_512[2];
        float viewBoxHeight = VIEW_BOX_512[3];
        if (viewBoxHeight <= 0 || viewBoxWidth <= 0 || bounds.width() <= 0 || bounds.height() <= 0) {
            return;
        }
        p.reset();
        float viewBoxRatio = viewBoxWidth / (float) viewBoxHeight;
        float boundsRatio = bounds.width() / (float) bounds.height();
        float factorScale;
        if (boundsRatio > viewBoxRatio) {
            factorScale = bounds.height() / (float) viewBoxHeight;
        } else {
            factorScale = bounds.width() / (float) viewBoxWidth;
        }
        int newViewBoxHeight = Math.round(factorScale * viewBoxHeight);
        int newViewBoxWidth = Math.round(factorScale * viewBoxWidth);
        int marginX = bounds.width() - newViewBoxWidth;
        int marginY = bounds.height() - newViewBoxHeight;
        p.reset();
        p.moveTo(factorScale * 43.203999f, factorScale * 433.313995f);
        p.rCubicTo(factorScale * -10.736000f, factorScale * 9.114000f, factorScale * -28.795000f,
                factorScale * 15.843000f, factorScale * -32.375000f, factorScale * 29.900000f);
        p.rCubicTo(factorScale * -5.918000f, factorScale * 12.526000f, factorScale * -11.669000f,
                factorScale * 31.225000f, factorScale * 17.080999f, factorScale * 18.700001f);
        p.rLineTo(factorScale * 0.128000f, factorScale * -0.168000f);
        p.rCubicTo(factorScale * 28.624001f, factorScale * -12.354000f, factorScale * 23.940001f,
                factorScale * -57.549000f, factorScale * 64.023003f, factorScale * -58.444000f);
        p.rCubicTo(factorScale * 2.046000f, factorScale * 2.473000f, factorScale * 4.003000f, factorScale * 5.028000f,
                factorScale * 5.111000f, factorScale * 8.650000f);
        p.rCubicTo(factorScale * 3.580000f, factorScale * -1.108000f, factorScale * 3.153000f, factorScale * 1.873000f,
                factorScale * 6.048000f, factorScale * 1.317000f);
        p.rCubicTo(factorScale * 9.075000f, factorScale * -11.543000f, factorScale * 29.990000f,
                factorScale * -8.177000f, factorScale * 32.758999f, factorScale * 6.349000f);
        p.rCubicTo(factorScale * 25.726000f, factorScale * 3.324000f, factorScale * 13.501000f,
                factorScale * -36.077000f, factorScale * 39.953999f, factorScale * -27.516001f);
        p.rCubicTo(factorScale * 4.939000f, factorScale * -6.561000f, factorScale * 9.372000f,
                factorScale * -14.141000f, factorScale * 13.204000f, factorScale * -22.150000f);
        p.rLineTo(factorScale * 0.000000f, factorScale * 0.000000f);
        p.rLineTo(0, factorScale * -0.426000f);
        p.rCubicTo(factorScale * 6.900000f, factorScale * -14.312000f, factorScale * 12.099000f,
                factorScale * -30.455999f, factorScale * 15.122000f, factorScale * -45.280998f);

        p.rCubicTo(factorScale * 8.816000f, factorScale * -25.513000f, factorScale * 19.808001f,
                factorScale * -55.458000f, factorScale * 27.943001f, factorScale * -71.559998f);
        p.rLineTo(0, factorScale * 0.129000f);
        p.rCubicTo(factorScale * 1.790000f, factorScale * -4.433000f, factorScale * 4.558000f, factorScale * -7.879000f,
                factorScale * 7.285000f, factorScale * -11.288000f);
        p.rCubicTo(factorScale * 0.849000f, factorScale * -0.853000f, factorScale * 1.661000f, factorScale * -1.108000f,
                factorScale * 2.514000f, factorScale * -1.108000f);
        p.rLineTo(factorScale * -1.664000f, factorScale * -0.172000f);
        p.rCubicTo(factorScale * 0.255000f, factorScale * -0.384000f, factorScale * 0.385000f, factorScale * -0.681000f,
                factorScale * 0.811000f, factorScale * -0.937000f);
        p.rCubicTo(factorScale * 0.298000f, factorScale * 0.255000f, factorScale * 0.682000f, factorScale * 0.682000f,
                factorScale * 0.853000f, factorScale * 1.108000f);
        p.rCubicTo(factorScale * 0.000000f, factorScale * 0.125000f, factorScale * 0.000000f, factorScale * 0.125000f,
                factorScale * 0.255000f, factorScale * 0.125000f);
        p.rLineTo(factorScale * 2.467000f, factorScale * 50.646999f);
        p.rLineTo(0, factorScale * 0.129000f);
        p.rCubicTo(factorScale * -0.255000f, factorScale * 0.000000f, factorScale * -0.255000f, factorScale * 0.168000f,
                factorScale * -0.422000f, factorScale * 0.297000f);
        p.rCubicTo(factorScale * -0.385000f, factorScale * 0.126000f, factorScale * -0.385000f, factorScale * 0.126000f,
                factorScale * -0.682000f, factorScale * 0.297000f);
        p.rCubicTo(factorScale * -0.255000f, factorScale * 0.129000f, factorScale * -0.255000f, factorScale * 0.255000f,
                factorScale * -0.557000f, factorScale * 0.255000f);
        p.rCubicTo(factorScale * -0.255000f, factorScale * 0.000000f, factorScale * -0.384000f, factorScale * 0.129000f,
                factorScale * -0.552000f, factorScale * 0.297000f);
        p.rCubicTo(factorScale * -0.130000f, factorScale * 0.255000f, factorScale * -0.255000f, factorScale * 0.255000f,
                factorScale * -0.255000f, factorScale * 0.255000f);
        p.rCubicTo(factorScale * -0.255000f, factorScale * 0.342000f, factorScale * -0.426000f, factorScale * 0.426000f,
                factorScale * -0.555000f, factorScale * 0.556000f);
        p.rCubicTo(factorScale * -0.255000f, factorScale * 0.000000f, factorScale * -0.255000f, factorScale * 0.000000f,
                factorScale * -0.553000f, factorScale * 0.340000f);
        p.rCubicTo(factorScale * 0.000000f, factorScale * 0.000000f, factorScale * -0.255000f, factorScale * 0.129000f,
                factorScale * -0.426000f, factorScale * 0.212000f);
        p.rLineTo(factorScale * -0.126000f, factorScale * 0.641000f);
        p.rLineTo(factorScale * -0.255000f, factorScale * 0.254000f);
        p.rCubicTo(factorScale * 0.000000f, factorScale * 0.000000f, factorScale * -0.130000f, factorScale * 0.297000f,
                factorScale * -0.301000f, factorScale * 0.427000f);
        p.rLineTo(0, factorScale * 0.297000f);
        p.rCubicTo(factorScale * -0.255000f, factorScale * 0.682000f, factorScale * -0.553000f, factorScale * 1.193000f,
                factorScale * -0.553000f, factorScale * 2.046000f);
        p.rLineTo(factorScale * 0.000000f, factorScale * 0.000000f);
        p.rCubicTo(factorScale * 0.000000f, factorScale * 0.297000f, factorScale * 0.000000f, factorScale * 0.553000f,
                factorScale * -0.255000f, factorScale * 0.849000f);
        p.rLineTo(0, factorScale * 0.172000f);
        p.rCubicTo(factorScale * 0.000000f, factorScale * 0.214000f, factorScale * 0.255000f, factorScale * 0.343000f,
                factorScale * 0.255000f, factorScale * 0.681000f);
        p.rLineTo(0, factorScale * 0.255000f);
        p.rLineTo(0, factorScale * 0.724000f);
        p.rLineTo(0, factorScale * 0.129000f);
        p.rCubicTo(factorScale * 0.000000f, factorScale * 0.000000f, factorScale * 0.130000f, factorScale * 0.297000f,
                factorScale * 0.130000f, factorScale * 0.724000f);
        p.rLineTo(factorScale * 0.126000f, 0);

        p.rCubicTo(factorScale * 0.000000f, factorScale * 0.255000f, factorScale * 0.000000f, factorScale * 0.681000f,
                factorScale * 0.084000f, factorScale * 0.979000f);
        p.rLineTo(factorScale * 0.000000f, factorScale * 0.000000f);
        p.rLineTo(factorScale * 0.130000f, 0);
        p.rCubicTo(factorScale * 0.000000f, factorScale * 0.214000f, factorScale * 0.296000f, factorScale * 0.681000f,
                factorScale * 0.296000f, factorScale * 1.025000f);
        p.rLineTo(factorScale * 0.000000f, factorScale * 0.000000f);
        p.rCubicTo(factorScale * 0.255000f, factorScale * 0.468000f, factorScale * 0.385000f, factorScale * 0.724000f,
                factorScale * 0.557000f, factorScale * 1.108000f);
        p.rLineTo(factorScale * 0.000000f, factorScale * 0.000000f);
        p.rCubicTo(factorScale * 0.255000f, factorScale * 0.297000f, factorScale * 0.594000f, factorScale * 0.552000f,
                factorScale * 0.937000f, factorScale * 0.849000f);
        p.rLineTo(factorScale * 0.000000f, factorScale * 0.000000f);
        p.rCubicTo(factorScale * 1.234000f, factorScale * 1.618000f, factorScale * 2.893000f, factorScale * 3.279000f,
                factorScale * 4.814000f, factorScale * 4.432000f);
        p.rCubicTo(factorScale * 0.000000f, factorScale * 0.000000f, factorScale * 0.126000f, factorScale * 0.255000f,
                factorScale * 0.298000f, factorScale * 0.255000f);
        p.rCubicTo(factorScale * 0.255000f, factorScale * 0.297000f, factorScale * 0.552000f, factorScale * 0.297000f,
                factorScale * 0.807000f, factorScale * 0.553000f);
        p.rLineTo(factorScale * 0.426000f, 0);
        p.rCubicTo(factorScale * 0.130000f, factorScale * 0.297000f, factorScale * 0.427000f, factorScale * 0.297000f,
                factorScale * 0.682000f, factorScale * 0.552000f);
        p.rLineTo(factorScale * 0.555000f, 0);
        p.rCubicTo(factorScale * 0.255000f, factorScale * 0.302000f, factorScale * 0.255000f, factorScale * 0.427000f,
                factorScale * 0.552000f, factorScale * 0.598000f);
        p.rLineTo(factorScale * 0.811000f, 0);
        p.rCubicTo(factorScale * 18.184999f, factorScale * 12.949000f, factorScale * 9.624000f,
                factorScale * -17.209999f, factorScale * 8.135000f, factorScale * -32.074001f);
        p.rCubicTo(factorScale * -0.426000f, factorScale * -1.961000f, factorScale * -0.426000f,
                factorScale * -3.706000f, factorScale * -0.681000f, factorScale * -5.668000f);
        p.rCubicTo(factorScale * 0.811000f, factorScale * -6.047000f, factorScale * 0.811000f, factorScale * -7.410000f,
                factorScale * 0.811000f, factorScale * -8.519000f);
        p.rCubicTo(factorScale * 0.000000f, factorScale * -0.552000f, factorScale * 0.381000f, factorScale * -0.979000f,
                factorScale * 0.381000f, factorScale * -1.405000f);
        p.rCubicTo(factorScale * 0.598000f, factorScale * -2.046000f, factorScale * 6.775000f, factorScale * -7.541000f,
                factorScale * 10.309000f, factorScale * -15.675000f);
        p.rCubicTo(factorScale * 9.795000f, factorScale * 19.422001f, factorScale * 36.930000f,
                factorScale * 73.901001f, factorScale * 40.167000f, factorScale * 86.385002f);
        p.rCubicTo(factorScale * 0.853000f, factorScale * 6.642000f, factorScale * 3.195000f, factorScale * 14.948000f,
                factorScale * 7.712000f, factorScale * 13.759000f);
        p.rCubicTo(factorScale * -1.618000f, factorScale * 13.630000f, factorScale * 8.009000f,
                factorScale * 37.737000f, factorScale * 21.212999f, factorScale * 45.194000f);
        p.rCubicTo(factorScale * 3.836000f, factorScale * 0.126000f, factorScale * 4.132000f, factorScale * -3.324000f,
                factorScale * 8.649000f, factorScale * -2.471000f);
        p.rCubicTo(factorScale * 11.711000f, factorScale * 7.666000f, factorScale * 7.583000f, factorScale * 31.606001f,
                factorScale * 29.900000f, factorScale * 28.879000f);
        p.rCubicTo(factorScale * 7.156000f, factorScale * -21.339001f, factorScale * 23.086000f,
                factorScale * -8.009000f, factorScale * 37.867001f, factorScale * -3.878000f);
        p.rCubicTo(factorScale * 9.758000f, factorScale * -25.000999f, factorScale * 36.720001f,
                factorScale * -0.214000f, factorScale * 48.856998f, factorScale * 20.150000f);
        p.rCubicTo(factorScale * 10.736000f, factorScale * 18.658001f, factorScale * 20.363001f,
                factorScale * 40.978001f, factorScale * 41.278999f, factorScale * 26.281000f);
        p.rCubicTo(factorScale * 4.555000f, factorScale * -29.305000f, factorScale * -13.717000f,
                factorScale * -32.074001f, factorScale * -28.882999f, factorScale * -42.555000f);
        p.rCubicTo(factorScale * -19.297001f, factorScale * -13.459000f, factorScale * -43.789001f,
                factorScale * -42.129002f, factorScale * -33.904999f, factorScale * -67.853996f);
        p.rCubicTo(factorScale * 4.174000f, factorScale * 0.427000f, factorScale * 4.429000f, factorScale * -3.195000f,
                factorScale * 8.816000f, factorScale * -2.384000f);
        p.rCubicTo(factorScale * 8.820000f, factorScale * -15.935000f, factorScale * -5.069000f,
                factorScale * -26.667000f, factorScale * -3.576000f, factorScale * -43.747002f);
        p.rCubicTo(factorScale * 29.690001f, factorScale * -6.901000f, factorScale * -7.712000f,
                factorScale * -34.118999f, factorScale * 7.453000f, factorScale * -46.514999f);
        p.rCubicTo(factorScale * 2.853000f, factorScale * -23.513000f, factorScale * -25.517000f,
                factorScale * -26.027000f, factorScale * -27.816000f, factorScale * -48.729000f);
        p.rCubicTo(factorScale * 41.020000f, factorScale * 2.343000f, factorScale * 36.123001f,
                factorScale * -33.438000f, factorScale * 51.756001f, factorScale * -56.438999f);
        p.rCubicTo(factorScale * -7.411000f, factorScale * -14.613000f, factorScale * 7.495000f,
                factorScale * -23.940001f, factorScale * 0.000000f, factorScale * -38.678001f);
        p.rCubicTo(factorScale * 2.129000f, factorScale * -3.154000f, factorScale * 2.471000f, factorScale * -8.391000f,
                factorScale * 6.090000f, factorScale * -10.180000f);
        p.rLineTo(0, factorScale * -16.101000f);
        p.rCubicTo(factorScale * 10.351000f, factorScale * -18.444000f, factorScale * 14.145000f,
                factorScale * -43.618000f, factorScale * 14.868000f, factorScale * -71.265999f);
        p.rCubicTo(factorScale * -8.820000f, factorScale * -13.501000f, factorScale * -36.039001f,
                factorScale * -14.650000f, factorScale * -52.307999f, factorScale * -11.585000f);
        p.rCubicTo(factorScale * -33.056999f, factorScale * 6.733000f, factorScale * -76.674004f,
                factorScale * 40.338001f, factorScale * -100.359001f, factorScale * 62.747002f);
        p.rCubicTo(factorScale * -27.302000f, factorScale * 25.813000f, factorScale * -47.151001f,
                factorScale * 57.162998f, factorScale * -63.935001f, factorScale * 86.084000f);
        p.rCubicTo(factorScale * -4.517000f, factorScale * 3.279000f, factorScale * -7.285000f, factorScale * 8.775000f,
                factorScale * -7.285000f, factorScale * 14.868000f);
        p.rCubicTo(factorScale * 0.000000f, factorScale * 0.808000f, factorScale * 0.129000f, factorScale * 1.360000f,
                factorScale * 0.129000f, factorScale * 2.171000f);
        p.rCubicTo(factorScale * -2.598000f, factorScale * 6.475000f, factorScale * -4.132000f,
                factorScale * 15.124000f, factorScale * -10.180000f, factorScale * 13.204000f);
        p.rCubicTo(factorScale * 12.819000f, factorScale * -6.303000f, factorScale * -3.324000f,
                factorScale * -14.141000f, factorScale * -4.943000f, factorScale * -21.297001f);
        p.rCubicTo(factorScale * -8.135000f, factorScale * 2.046000f, factorScale * -14.993000f,
                factorScale * 5.069000f, factorScale * -20.105000f, factorScale * 10.051000f);
        p.rCubicTo(factorScale * -0.807000f, factorScale * 4.517000f, factorScale * 2.769000f, factorScale * 4.943000f,
                factorScale * 2.473000f, factorScale * 8.775000f);
        p.rLineTo(factorScale * -5.070000f, 0);

        p.rCubicTo(factorScale * -26.579000f, factorScale * -69.388000f, factorScale * -91.283997f,
                factorScale * -143.800003f, factorScale * -166.380997f, factorScale * -167.785004f);
        p.cubicTo(factorScale * 46.784000f, factorScale * 27.200001f, factorScale * -6.331000f,
                factorScale * 23.155001f, factorScale * 9.214000f, factorScale * 60.340000f);
        p.rCubicTo(factorScale * -0.167000f, factorScale * 0.849000f, factorScale * -0.167000f, factorScale * 1.406000f,
                factorScale * -0.167000f, factorScale * 1.958000f);
        p.rCubicTo(factorScale * 0.000000f, factorScale * 1.920000f, factorScale * 0.552000f, factorScale * 3.836000f,
                factorScale * 1.786000f, factorScale * 5.199000f);
        p.rCubicTo(factorScale * 2.769000f, factorScale * 17.888000f, factorScale * 10.054000f,
                factorScale * 30.836000f, factorScale * 16.101999f, factorScale * 45.278000f);
        p.rCubicTo(factorScale * -1.235000f, factorScale * 10.861000f, factorScale * 2.087000f,
                factorScale * 16.954000f, factorScale * 6.348000f, factorScale * 22.576000f);
        p.rCubicTo(factorScale * 0.807000f, factorScale * 7.582000f, factorScale * -2.087000f, factorScale * 11.158000f,
                factorScale * -2.514000f, factorScale * 17.465000f);
        p.rCubicTo(factorScale * 7.708000f, factorScale * 6.600000f, factorScale * 4.982000f, factorScale * 16.525000f,
                factorScale * 4.982000f, factorScale * 30.070999f);
        p.rCubicTo(factorScale * 15.164000f, factorScale * 18.105000f, factorScale * 15.675000f,
                factorScale * 51.115002f, factorScale * 46.389999f, factorScale * 53.754002f);
        p.rCubicTo(factorScale * -1.920000f, factorScale * 6.178000f, factorScale * -4.814000f,
                factorScale * 11.289000f, factorScale * -9.243000f, factorScale * 14.868000f);
        p.rCubicTo(factorScale * -5.198000f, factorScale * 1.790000f, factorScale * -8.946000f, factorScale * 5.622000f,
                factorScale * -10.694000f, factorScale * 10.310000f);
        p.rLineTo(factorScale * -0.297000f, 0);
        p.rCubicTo(factorScale * -2.597000f, factorScale * 4.684000f, factorScale * -2.597000f, factorScale * 8.134000f,
                factorScale * -3.534000f, factorScale * 12.392000f);
        p.rCubicTo(factorScale * 2.212000f, factorScale * 1.918000f, factorScale * 3.534000f, factorScale * 4.814000f,
                factorScale * 4.939000f, factorScale * 7.410000f);
        p.rCubicTo(factorScale * -0.937000f, factorScale * 16.784000f, factorScale * -14.186000f,
                factorScale * 17.507000f, factorScale * -11.288000f, factorScale * 30.159000f);
        p.rCubicTo(factorScale * 1.535000f, factorScale * 6.473000f, factorScale * 11.033000f, factorScale * 6.988000f,
                factorScale * 12.694000f, factorScale * 13.889000f);
        p.rCubicTo(factorScale * 2.170000f, factorScale * 11.033000f, factorScale * -10.223000f,
                factorScale * 19.677000f, factorScale * -6.349000f, factorScale * 34.969002f);
        p.rCubicTo(factorScale * 3.834000f, factorScale * 6.603000f, factorScale * 13.889000f, factorScale * 6.859000f,
                factorScale * 16.231001f, factorScale * 15.039000f);
        p.rCubicTo(factorScale * -3.622000f, factorScale * 27.389999f, factorScale * -16.146999f,
                factorScale * 44.724998f, factorScale * -31.396000f, factorScale * 57.632000f);
        p.lineTo(factorScale * 43.203999f, factorScale * 433.313995f);
        p.lineTo(factorScale * 43.203999f, factorScale * 433.313995f);
        p.close();
        p.moveTo(factorScale * 43.203999f, factorScale * 433.313995f);
        p.moveTo(factorScale * 321.356995f, factorScale * 373.549011f);
        p.rCubicTo(factorScale * 0.000000f, factorScale * 0.469000f, factorScale * 0.000000f, factorScale * 0.639000f,
                factorScale * -0.301000f, factorScale * 0.983000f);
        p.rCubicTo(factorScale * 0.000000f, factorScale * -0.385000f, factorScale * -0.126000f,
                factorScale * -0.556000f, factorScale * -0.126000f, factorScale * -0.983000f);
        p.lineTo(factorScale * 321.356995f, factorScale * 373.549011f);
        p.lineTo(factorScale * 321.356995f, factorScale * 373.549011f);

        p.close();
        p.moveTo(factorScale * 321.356995f, factorScale * 373.549011f);
        p.moveTo(factorScale * 315.138000f, factorScale * 363.114014f);
        p.rCubicTo(factorScale * 0.297000f, factorScale * 0.598000f, factorScale * 0.552000f, factorScale * 0.853000f,
                factorScale * 0.849000f, factorScale * 1.492000f);
        p.rCubicTo(factorScale * -1.660000f, factorScale * -1.492000f, factorScale * -1.957000f,
                factorScale * -2.601000f, factorScale * -2.342000f, factorScale * -3.964000f);
        p.cubicTo(factorScale * 314.028992f, factorScale * 361.626007f, factorScale * 314.582001f,
                factorScale * 362.307007f, factorScale * 315.138000f, factorScale * 363.114014f);
        p.lineTo(factorScale * 315.138000f, factorScale * 363.114014f);
        p.close();
        p.moveTo(factorScale * 315.138000f, factorScale * 363.114014f);
        p.moveTo(factorScale * 158.807007f, factorScale * 386.542999f);
        p.rCubicTo(factorScale * 0.000000f, factorScale * 0.000000f, factorScale * -0.255000f, factorScale * 0.255000f,
                factorScale * -0.380000f, factorScale * 0.255000f);
        p.rLineTo(0, factorScale * -0.255000f);
        p.lineTo(factorScale * 158.807007f, factorScale * 386.542999f);
        p.lineTo(factorScale * 158.807007f, factorScale * 386.542999f);
        p.close();
        p.offset(bounds.left, bounds.top);
        p.setFillType(Path.FillType.EVEN_ODD);
    }

}


