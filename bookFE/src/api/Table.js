import request from '@/utils/request'

const baseurl = 'Table/'



export function bookreaders(query) {
    return request({
        url: baseurl+'bookreaders',
        method: 'post',
        data: query
    })
}

export function borrowreaders(query) {
    return request({
        url: baseurl+'borrowreaders',
        method: 'post',
        data: query
    })
}

