function _extends() { _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; }; return _extends.apply(this, arguments); }

import React from 'react';

const SvgShapeCordate = props => React.createElement("svg", _extends({
  width: "3em",
  height: "3em",
  viewBox: "0 0 150 105",
  fill: "none"
,
margin: "0.5em 1em",
      ), React.createElement("path", {
  d: "M132.5 54L148 52.5L147.5 57.5L149 63L144 60L134.5 59H111.5L119.502 73.2254C120.16 74.3964 120.576 75.6883 120.725 77.0237L121 79.5L120.683 82.6689C120.562 83.8795 120.221 85.0578 119.677 86.146L118.156 89.1873C117.721 90.0578 117.161 90.8601 116.494 91.5688L112.092 96.2461C110.391 98.0538 108.267 99.4109 105.912 100.196L97.5 103L90 104L77 101.5L50.3592 92.3422C46.8177 91.1248 43.5355 89.2551 40.6821 86.8298L25 73.5L1 56L13 46L23.5 36L39.5222 16.6243C43.102 12.2952 47.8255 9.05818 53.1547 7.28176L65.4687 3.17709C67.8139 2.39536 70.2467 1.90649 72.7119 1.72161L83.4318 0.917618C87.1123 0.641576 90.8122 1.04708 94.3456 2.11377L110.007 6.84173C113.597 7.92538 116.809 9.99631 119.278 12.8182L122.284 16.2533C124.68 18.991 126 22.5051 126 26.1429C126 28.3537 125.512 30.5372 124.571 32.5376L122 38L111.5 54H132.5Z",
  fill: "#2ECC71",
  stroke: "#2ECC71"
}));

export default SvgShapeCordate;