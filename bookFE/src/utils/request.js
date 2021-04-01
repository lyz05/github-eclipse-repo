import axios from 'axios'
import { Message } from 'element-ui'

// create an axios instance
const service = axios.create({
    //baseURL: 'http://tomcat.home999.cc:8050/book/', // url = base url + request url
    baseURL: 'http://localhost:8000/api/',
    withCredentials: true, // send cookies when cross-domain requests
    timeout: 2000 // request timeout
})

// request interceptor
service.interceptors.request.use(
    config => {
        // do something before request is sent

        return config
    },
    error => {
        // do something with request error
        console.log(error) // for debug
        return Promise.reject(error)
    }
)

// response interceptor
service.interceptors.response.use(
    /**
     * If you want to get http information such as headers or status
     * Please return  response => response
     */

    /**
     * Determine the request status by custom code
     * Here is just an example
     * You can also judge the status by HTTP Status Code
     */
    response => {
        const res = response.data
        if ("code" in res) {
            if (res.code===200) {
                Message({
                    message: res.message || 'Error',
                    type: 'success',
                    duration: 3 * 1000
                })
            } else if (res.code===403) {
                Message({
                    message: res.message || 'Error',
                    type: 'error',
                    duration: 3 * 1000
                })
            }
        }
        return res
    },
    error => {
        console.log(error.response) // for debug
        let message;
        if (error.response) {
            message = "HTTP Response Error: "+error.response.status+','+error.response.statusText
            if (error.response.status===401) message = "您还未登录，请刷新页面重新登录"
        } else if (error.request) {
            message = "HTTP Request Error: "+error.message
        } else {
            message = error.message
        }
        Message({
            message: message,
            type: 'error',
            duration: 3 * 1000
        })
        return Promise.reject(error)
    }
)

export default service