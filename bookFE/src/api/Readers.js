import request from '@/utils/request'

const baseurl = 'Readers'

export function getreaders(query) {
    return request({
        url: baseurl,
        method: 'get',
        params: query
    })
}

export function getreader(readerno) {
    return request({
        url: baseurl+"/"+readerno,
        method: 'get'
    })
}

export function addreader(reader) {
    return request({
        url: baseurl,
        method: 'post',
        data: reader
    })
}

export function editreader(reader) {
    return request({
        url: baseurl,
        method: 'put',
        data: reader
    })
}

export function delreader(readerno) {
    return request({
        url: baseurl+"/"+readerno,
        method: 'delete'
    })
}