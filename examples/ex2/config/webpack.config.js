var HtmlWebpackPlugin = require('html-webpack-plugin');
var CopyWebpackPlugin = require('copy-webpack-plugin');
var cfg = require('./scalajs.webpack.config');
var path = require('path');
var rootDir = path.dirname(path.dirname(path.dirname(path.dirname(__dirname))));
var nodeModulesDir = path.join(__dirname, 'node_modules');

cfg.output.path = path.join(rootDir, 'build');

cfg.module = cfg.module || {};
cfg.module.loaders = cfg.module.loaders || [];
cfg.module.loaders.push(
  {
    test: /\.html$/,
    loader: 'html'
  },
  {
     test: /\.css$/,
     loader: "style-loader!css-loader?root=."
  }
);

cfg.plugins = cfg.plugins || [];

cfg.plugins.push(new CopyWebpackPlugin([
  { from: path.join(nodeModulesDir, 'react-mdl/extra/material.css'), to: 'mdl/material.css' },
  { from: path.join(nodeModulesDir, 'react-mdl/extra/material.js'), to: 'mdl/material.js' },
  { from: path.join(rootDir, 	    'src/main/assets/index.css'), to: 'css/index.css' }
]));

cfg.plugins.push(new HtmlWebpackPlugin({
  template: path.join(rootDir, 'src/main/assets/index.html')
}));

cfg.bail = true;

module.exports = cfg;