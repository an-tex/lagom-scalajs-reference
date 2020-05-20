module.exports = require('./scalajs.webpack.config');

module.exports.module.rules = (module.exports.module.rules || []).concat([
    {
        test: /\.less$/,
        use: [{
            loader: 'style-loader',
        }, {
            loader: 'css-loader', // translates CSS into CommonJS
        }, {
            loader: 'less-loader', // compiles Less to CSS
            options: {
                lessOptions: {
                    // modifyVars: {
                    // 'primary-color': '#1DA57A',
                    // 'link-color': '#1DA57A',
                    // 'border-radius-base': '5px',
                    // },
                    javascriptEnabled: true,
                }
            }
        }]
    }
]);
