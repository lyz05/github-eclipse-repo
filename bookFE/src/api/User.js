import request from '@/utils/request'

const baseurl = 'User/'

export function userinfo() {
    return request({
        url: baseurl+'userinfo',
        method: 'get'
    })
}

export function login(query) {
    return request({
        url: baseurl+'login',
        method: 'post',
        data: query
    })
}

export function logout() {
    return request({
        url: baseurl+'logout',
        method: 'get'
    })
}

export function psdalter(query) {
    return request({
        url: baseurl+'psdalter',
        method: 'post',
        data: query
    })
}

export function resetpwd(query) {
    return request({
        url: baseurl+'resetpwd',
        method: 'post',
        data: query
    })
}