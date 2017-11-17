//统一验证区
$.extend($.fn.validatebox.defaults.rules, {
	NUll:{
		validator: function (value) {
			if (value.length == 0){
				return false;
			}
			else{
				return true;
			}
        },
        message: '此项不能为空'
	},
    maxLength: {
        validator: function (value, param) {
            return param[0] >= value.length;
        },
        message: '请输入最大{0}位字符'
    },
    minLength: {
        validator: function (value, param) {
            if (value.length == param[0]) {
                return true;
            }
            else {
                return false;
            }
        },
        message: '请在此输入{0}位的数字或字符'
    },
    Zipcode: {
        validator: function (value, param) {
            var re = /^[1-9][0-9]{5}$/
            if (re.test(value)) {
                return true;
            }
            else {
                return false;
            }
        },
        message: '请在此输入{0}位的数字'
    },
    CHS: {
        validator: function (value) {
            return /^[\u0391-\uFFE5]+$/.test(value);
        },
        message: '只能输入汉字'
    },
    QQ: {
        validator: function (value) {
            return /^[1-9]\d{4,9}$/i.test(value);
        },
        message: 'QQ号码格式不正确'
    },
    OrgName: {
        validator: function (value, param) {
            var isNotExist;

            $.ajax({
                url: "/Service/CheckOrgName",
                type: "POST",
                data: { spUserId: param[0], orgName: value },
                async: false,
                success: function (data) {
                    if (data == "True") {
                        isNotExist = false;
                    } else {
                        isNotExist = true;
                    }
                }
            });

            return isNotExist;
        },
        message: '该机构已注册'
    }
});