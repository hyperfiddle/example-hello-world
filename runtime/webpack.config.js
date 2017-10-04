var webpack = require('webpack');
var path = require('path');

var prod = process.env.NODE_ENV === 'production';

module.exports = {
  devtool: prod ? null : 'inline-source-map',
  entry: {
    browser: './preamble/browser'
  },

  output: {
    filename: 'preamble.js',
    path: 'generated-resources-browser'
  },

  resolve: {
    extensions: ['', '.js'],
    root: [ path.resolve('./preamble') ],
    modulesDirectories: ['node_modules']
  },
  plugins: [
    new webpack.NoErrorsPlugin(),
    prod ? new webpack.optimize.DedupePlugin() : null,
    prod ? new webpack.optimize.UglifyJsPlugin() : null
  ]
};
