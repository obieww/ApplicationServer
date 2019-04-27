## POST /api/user/register
- Request:
```json
{
  "username": "hugh",
  "password": "123"
}
```
- Response:
```json
{
  "userId": "2c92f4466a5c6bc8016a5c6d3ed40000",
  "username": "hugh",
  "password": "123",
  "obiewList": null,
  "followingList": null,
  "followerList": null
}
```

## POST /api/obiew/post
- Request:
```json
{
  "content": "this is content",
  "user": {
    "userId": "2c92f4466a5c6bc8016a5c6d3ed40000"
  }
}
```
- Response
```json
{
  "obiewId": "2c92f4466a5c6bc8016a5c7129130001",
  "content": "this is content",
  "likeList": null,
  "commentList": null
}
```
## POST /api/obiew/comment
- Request
> parent field is the obiew you want to comment
```json
{
  "content": "this is comment",
  "user": {
    "userId": "2c92f4466a5c6bc8016a5c6d3ed40000"
  },
  "parent": {
      "obiewId": "2c92f4466a5c6bc8016a5c7129130001",
      "content": "this is content"
  }
}
```
- Response
> response is the comment
```json
{
  "obiewId": "2c92f4466a5c6bc8016a5c74212f0003",
  "content": "this is comment",
  "likeList": null,
  "commentList": null
}
```

## GET /api/obiew/randomfeed
- response
```json
[
  {
    "obiewId": "2c92f4466a5c6bc8016a5c7129130001",
    "content": "this is content",
    "likeList": [],
    "commentList": [
      {
        "obiewId": "2c92f4466a5c6bc8016a5c73e7260002",
        "content": "this is comment",
        "likeList": [],
        "commentList": []
      },
      {
        "obiewId": "2c92f4466a5c6bc8016a5c74212f0003",
        "content": "this is comment",
        "likeList": [],
        "commentList": []
      }
    ]
  },
  {
    "obiewId": "2c92f4466a5c6bc8016a5c73e7260002",
    "content": "this is comment",
    "likeList": [],
    "commentList": []
  },
  {
    "obiewId": "2c92f4466a5c6bc8016a5c74212f0003",
    "content": "this is comment",
    "likeList": [],
    "commentList": []
  }
]
```