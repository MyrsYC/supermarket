<template>
  <div style="width: 50%;margin: 50px 0">
    <el-form :model="data.user" ref="formRef" :rules="rules" label-width="100px" label-position="right" style="padding-right: 40px">
        <el-form-item label="新密码" prop="newPassword">
          <el-input  v-model="data.user.newPassword" autocomplete="off"/>
        </el-form-item>
      <el-form-item label="确认密码" prop="new2Password">
        <el-input  v-model="data.user.new2Password" autocomplete="off"/>
      </el-form-item>

      <div style="text-align: center ;margin-top: 40px">
        <el-button type="primary" style="padding :20px 40px " @click="save">保存</el-button>
      </div>
    </el-form>
  </div>
</template>

<script setup>
import {reactive,ref} from "vue"
import {Delete, Edit} from '@element-plus/icons-vue'
import request from "@/utils/request";
import {ElMessage, ElMessageBox} from "element-plus";

const data = reactive({
 user: JSON.parse(localStorage.getItem('user') || '{}')
})

const rules = reactive ({
  newPassword: [
    { required: true, message: '请输入新密码', trigger: 'blur' },
  ],
  new2Password: [
    { required: true, message: '请确认新密码', trigger: 'blur' },
  ],
})

const formRef = ref()

const save = () => {
  formRef.value.validate((valid) => {
    if (valid) {
      request.put('/admin/updatePassword', data.user).then(res => {
        if (res.code === '200') {
          ElMessage.success('修改成功')
          localStorage.setItem('user', JSON.stringify(data.user))
        } else {
          ElMessage.error(res.msg)
        }
      })
    }
  })

}

</script>