$(function () {
        $('#form1').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                'yue': {
                    validators: {
                        notEmpty: {
                            message: '金额不能为空'
                        },
                        regexp: {  
                            regexp: /(^[1-9]\d*(\.\d{1,2})?$)|(^0(\.\d{1,2})?$)/,  
                            message: '金额格式错误'  
                        }  
                    }
                },
                'pwd': {
                    validators: {
                        notEmpty: {
                            message: '二级密码不能为空'
                        }
                    }
                },
                'digest': {
                    validators: {
                        notEmpty: {
                            message: '备注不能为空'
                        }
                    }
                }
            }
        });
    });
