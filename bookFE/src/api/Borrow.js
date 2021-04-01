import request from '@/utils/request'

const baseurl = 'Borrow'

export function addborrow(bookno) {
    return request({
        url: baseurl+"/"+bookno,
        method: 'post',
    })
}

export function retborrow(bookno) {
    return request({
        url: baseurl+"/"+bookno,
        method: 'delete',
    })
}

export function renewborrow(bookno) {
    return request({
        url: baseurl+"/"+bookno,
        method: 'put'
    })
}

