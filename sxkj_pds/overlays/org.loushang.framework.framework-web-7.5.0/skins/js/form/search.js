!function(a,b){'object'==typeof exports?module.exports=b(a,require('jquery')):'function'==typeof define&&define.amd?define(['jquery'],function(c){return b(a,c)}):b(a,a.jQuery)}(this,function(a,b,c){b.fn.search=function(a){var c=b(this),d=c.parent('.ue-search');d.length||(d=b("<div class=\"input-group\" style=\"display: none\"><input class=\"form-control ue-form\" type=\"text\" placeholder=\"请输入查询条件\"/><div class=\"input-group-addon ue-form-btn\"><span class=\"fa fa-arrow-circle-right\"></span></div></div>"),c.wrap('<div class="ue-search"></div>'),c.after(d)),c.click(function(){d.is(':visible')?d.css("display","none"):d.css("display","table")});var e=d.find('.ue-form');e.keydown(function(c){"13"==c.which&&a(b(this).val())});var f=d.find(".ue-form-btn");f.click(function(){a(e.val())})}});