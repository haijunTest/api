# api
Alibaba java style.

how to start development:
Fork the repo;
checkout to local;
·            git clone -b boot2 http://wumengchao@gitlab.ebyf.com.cn/wumengchao/api-gateway.git
develop & test;
on regular basis, submit merge request to boot2 branch; sample
on regular basis, sync with remote version
# display the remote info.
$ git remote -v
origin  http://wumengchao@gitlab.ebyf.com.cn/wumengchao/api-gateway.git (fetch)
origin  http://wumengchao@gitlab.ebyf.com.cn/wumengchao/api-gateway.git (push)
 
# add upstream (change the 'wumengchao@gitlab.ebyf.com.cn' part)
$ git remote add upstream  http://wumengchao@gitlab.ebyf.com.cn/ebyunfu/api-gateway.git
 
# verify remote info
$ git remote -v
origin  http://wumengchao@gitlab.ebyf.com.cn/wumengchao/api-gateway.git (fetch)
origin  http://wumengchao@gitlab.ebyf.com.cn/wumengchao/api-gateway.git (push)
upstream        http://wumengchao@gitlab.ebyf.com.cn/ebyunfu/api-gateway.git (fetch)
upstream        http://wumengchao@gitlab.ebyf.com.cn/ebyunfu/api-gateway.git (push)
 
# never push to remote master
$ git remote set-url --push upstream no_push
 
# display the remote info.
$ git remote -v
origin  http://wumengchao@gitlab.ebyf.com.cn/wumengchao/api-gateway.git (fetch)
origin  http://wumengchao@gitlab.ebyf.com.cn/wumengchao/api-gateway.git (push)
upstream        http://wumengchao@gitlab.ebyf.com.cn/ebyunfu/api-gateway.git (fetch)
upstream        no_push (push)
 
# fetch upstream changes
$ git fetch upstream
remote: Counting objects: 6, done.
remote: Compressing objects: 100% (4/4), done.
remote: Total 6 (delta 1), reused 0 (delta 0)
Unpacking objects: 100% (6/6), done.
From http://gitlab.ebyf.com.cn/ebyunfu/api-gateway
 * [new branch]      boot2      -> upstream/boot2
 * [new branch]      dev        -> upstream/dev
 * [new branch]      master     -> upstream/master
 
# merge upstream/boot branch chagnes.
$ git merge  upstream/boot2
Updating 98c1106..9e04165
Fast-forward
 README.md                    |  43 +++++++++++++++++++++++++++++++++++++++++++
 doc/images/merge_request.png | Bin 0 -> 26599 bytes
 2 files changed, 43 insertions(+)
 create mode 100644 doc/images/merge_request.png
 
# display current git status
$ git status
On branch boot2
Your branch is ahead of 'origin/boot2' by 1 commit.
  (use "git push" to publish your local commits)
 
nothing to commit, working tree clean
 
# submit local change to remote gitlab.
$ git push
Counting objects: 6, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (4/4), done.
Writing objects: 100% (6/6), 23.34 KiB | 11.67 MiB/s, done.
Total 6 (delta 1), reused 0 (delta 0)
remote:
remote: To create a merge request for boot2, visit:
remote:   http://gitlab.ebyf.com.cn/wumengchao/api-gateway/merge_requests/new?merge_request%5Bsource_branch%5D=boot2
remote:
To http://gitlab.ebyf.com.cn/wumengchao/api-gateway.git
   98c1106..9e04165  boot2 -> boot2
