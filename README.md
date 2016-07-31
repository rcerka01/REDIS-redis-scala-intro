# REDIS-redis-scala-intro

### SET UP

 install (mac): ```sh brew install redis ```

 run server: ```sh redis-server /usr/local/etc/redis.conf ```

 redis.conf: ```sh change port, bind host, etc. ```

 run client: ```sh redis-cli ```

 run monitor: ```sh redis-cli monitor ```

### DB

 change db:<br />
  &nbsp;select1<br />
  &nbsp;select 2<br />
  &nbsp;etc.<br />
 <br />
 After restart data is saved.<br />
 To delete data:<br />
   &nbsp;flushdb<br />
   &nbsp;flushall (for multiple db)<br />

### STRING AND KEYS

 set name Ray<br />
 set hobby "computers reading"<br />
 get name<br />
 get hobby<br />
 mset mamal whale insect "June Bug" (mset key name key name key name etc)<br />
 get mamal<br />
 get insect<br />
 <br />
 keys name<br />
 keys * or keys nam*<br />
 exists dog<br />
 del name - return 1 or 0<br />
 rename name myname - rename key<br />
 setnx or  <br />
 pexpire name - expire in 5s<br />
 persist name - check if it still exist (0 or 1)<br />
 ttl name - time to live (sec or -1)<br />
 <br />
 strlen name

### INT

 set age 20<br />
 incr age<br />
 incrby age 5<br />
 decr age<br />

### HASH

 hset people Jan 12<br />
 hset people Ray 32<br />
 hget people Ray<br />
 hgetall people<br />
 hmset people kim 9 sue 12<br />
 hdel people Ray Jan<br />
 hlen people - how many<br />
<br />
 hmset scores u1 0 u2 0 u3 0<br />
 hincrby scores u1 2<br />
 hexists scores u6 - exists (0 or 1)<br />
 hkeys scores<br />
 hvals scores<br />

### LISTS

 lpush colors red green blue - new list with elements<br />
 llen colors - length<br />
 lrange colors 0 -1 - all list<br />
 lrange colors 0 2 - segment<br />
 lset colors 0 newcolor - for existing list value change it<br />
 linsert colors after blue purple<br />
 lpop colors - remove first<br />
 rpop colors - remove last<br />
<br />
 lpushx animals pig -push only if list exist<br />
 lrem colors 2 red - amount of values to remove (front to backwards)<br />
 lrem colors -2 red - amount of values to remove (back to forwards)<br />
 lrem colors 0 red - remove all red<br />
 rpush colors yellow - push to right<br />
<br />
 cannot create list within the list!

### SETS

 sadd art pencill paint brush canvas - create set with elements (return int elements)<br />
 scard art - count elements<br />
 srem art pencil - remove element (0 or 1)<br />
 sadd art pencil - add (0 if already exist or 1)<br />
 smembers art - all members<br />
 sismember art pencil - is member<br />
 sunion art art2 - join unique elements<br />
 sdiff art art2 - unique art elements which are not in art2<br />
 sinter art art2 - common element<br />
 sunionstore x art art2 - save union as x<br />
 sdiffstore..<br />
 sinterstore..<br />

### SORTED SETS (player scores in the game etc.)

 zadd players 10 ben 20 kim 40 tammy - z -> sorted<br />
 zadd players 15 tiger<br />
 zrange players 0 -1<br />
 zrange players 0 -1 withscores - keys and values<br />
 zrevrange players 0 -1<br />
 zrevrange players 0 0 - last one<br />
 zscore players kim<br />
 zcard players - how many players<br />
 zcount players 0 20 - count players with score 0 - 20<br />
 zrangebyscore players 0 30 - player names with score 0 - 30<br />

### HYPERLOGLOG

 for big datasets instead of use sets and sadd:<br />
 pfadd .. then merge and count per period..<br />

### PUBSUB

 subscribe general - clients (also as a redis-cli)<br />
 subscribe farmers<br />
 publish general "How are you?" - broadcaster<br />
 pubsub channels * - list subscribers (from broadcaster)<br />
<br />
 psubscribe pr* - client subscribe to any chanel started with pr<br />
 publish problem problem1 - from broadcaster<br />
 psubscribe h[ea]llo<br />
 publish hello man - ok<br />
 publish hallo man - ok<br />
 publish hllo man - not ok<br />

### TRANSACTIONS

 MULTI - to start<br />
 set day bright (qued)<br />
 EXEC - executed (executed)<br />
 DISCARD - cancel transaction<br />

### COMMANDS

 echo hallo - echo something<br />
 ping - ping redis<br />
 set - set name<br />
 select 0 - delect db<br />
 quit - quit redis<br />
 auth - in config file set -> requirepass password and restart redis server<br />

