webpackJsonp([11],{"59il":function(t,s,a){"use strict";Object.defineProperty(s,"__esModule",{value:!0});var n={data:function(){return{spanAuto:1}},mounted:function(){},methods:{start:function(){this.spanAuto=1,this.courseAjax(1)},end:function(){this.spanAuto=0,this.courseAjax(2)},courseAjax:function(t){this.axios({url:"http://api.zhituteam.com/api/course/studentlists",method:"get",params:{status:t},withCredentials:!1,responseType:"json"}).then(function(t){alert(t.data.message)}).catch(function(t){alert("ajax请求出错，错误信息："+t)})}}},e={render:function(){var t=this.$createElement,s=this._self._c||t;return s("div",{attrs:{id:"app"}},[s("div",{staticClass:"head"},[s("span",{class:{spanAuto:this.spanAuto},on:{click:this.start}},[this._v("未开始")]),this._v(" "),s("span",{class:{spanAuto:!this.spanAuto},on:{click:this.end}},[this._v("已结束")])])])},staticRenderFns:[]};var i=a("vSla")(n,e,!1,function(t){a("FJ0+")},"data-v-6e10b583",null);s.default=i.exports},"FJ0+":function(t,s){}});
//# sourceMappingURL=11.ed64a35e3b23c2a10b78.js.map