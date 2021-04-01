import request from '@/utils/request'

const baseurl = 'Books'

export function getbooks(query) {
    return request({
        url: baseurl,
        method: 'get',
        params: query
    })
}

export function getbook(bookno) {
    return request({
        url: baseurl+"/"+bookno,
        method: 'get'
    })
}

export function addbook(book) {
    return request({
        url: baseurl,
        method: 'post',
        data: book
    })
}

export function editbook(book) {
    return request({
        url: baseurl,
        method: 'put',
        data: book
    })
}

export function delbook(bookno) {
    return request({
        url: baseurl+"/"+bookno,
        method: 'delete'
    })
}