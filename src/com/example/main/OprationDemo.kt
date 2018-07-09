package com.example.main

/**
 * Created by ls on 18/4/8.
 */
class OprationDemo {

    companion object {
        val list = arrayListOf(-1, -2, 0, 1, 2, 3, 0, 100, 1000, 10000)
        val strList = arrayListOf("b", "ls", "a", "mtime", "wanda")

        fun main() {
            //聚合操作
            aggregateOperation()
            //筛选操作
            filterOperation()
            //映射操作
            reflectOperation()
            //元素操作
            elementOperation()
            //生成操作
            generateOperation()
            //排序操作
            sortOperation()

        }

        /**
         * 聚合操作
         */
        private fun aggregateOperation() {
            any()
            all()
            count()
            fold()
            foldRight()
            forEach()
            forEachIndexed()
            max()
            maxBy()
            min()
            minBy()
            none()
            reduce()
            reduceRight()
            sumBy()
        }

        /**
         * 筛选操作
         */
        private fun filterOperation() {
            drop()
            dropWhile()
            dropLastWhile()
            filter()
            filterNot()
            filterNotNull()
            slice()
            take()
            takeLast()
            takeWhile()
        }

        /**
         * 映射操作
         */
        private fun reflectOperation() {
            flatMap()
            groupBy()
            map()
            mapIndexed()
            mapNotNull()
        }

        /**
         * 元素操作
         */
        private fun elementOperation() {
            contains()
            elementAt()
            elementAtOrElse()
            elementAtOrNull()
            first()
            indexOf()
            indexOfFirst()
            indexOfLast()
            last()
            lastIndexOf()
            lastOrNull()
            single()
            singleOrNull()
        }

        /**
         * 生成操作
         */
        private fun generateOperation() {
            partition()
            plus()
            zip()
            minus()
        }

        /**
         * 排序操作
         */
        private fun sortOperation() {
            reverse()
            sort()
            sortBy()
            sortDescending()
        }

        private fun any() {
            //如果至少有一个满足条件的 return true
            println("list.any =${list.any { it < -2 }}")
        }

        private fun all() {
            //如果所有条件都满足条件 return true
            println("list.all() = ${list.all { it > -3 }}")
        }

        private fun count() {
            //返回满足条件的元素个数
            println("list.count() = ${list.count { it >= 10 }}")
        }

        private fun fold() {
            //将集合中从第一个元素到最后一个元素进行累加操作，并加上初始值
            println("list.fold() = ${list.fold(0) { total, next -> total + next }}")
            println("strList.fold() = ${strList.fold("") { total, next -> total + next }}")
        }

        private fun foldRight() {
            //从最后一个元素到第一个元素进行累加，并加上初始值
            println("list.foldRight() = ${list.foldRight(0) { total, next -> total + next }}")
        }

        private fun forEach() {
            //遍历集合中的元素
            list.forEach(::println)
        }

        private fun forEachIndexed() {
            //遍历集合中元素，可以获取元素和索引
            list.forEachIndexed { index, value ->
                println("index:$index,value:$value")
            }
        }

        private fun max() {
            //返回集合中的最大值
            println("list.max() = ${list.max()}")
            println("strList.max() = ${strList.max()}")
        }

        private fun maxBy() {
            //返回根据给出的条件得出的最大值对应集合中的值
            println("list.maxBy() = ${list.maxBy { it / 5 }}")
        }

        private fun min() {
            //返回集合中的最小值
            println("list.min() = ${list.min()}")
            println("strList.min() = ${strList.min()}")
        }

        private fun minBy() {
            //返回根据条件得出的第一个最小值对应的集合中的元素
            println("list.minBy() = ${list.minBy { it / 5f }}")
        }

        private fun none() {
            //如果不存在符合给定条件的元素 return true
            println("list.none() = ${list.none { it % 2 == 0 }}")
        }

        private fun reduce() {
            //从第一个元素到最后一个元素累加
            println("list.reduce() = ${list.reduce { total, next -> total + next }}")
        }

        private fun reduceRight() {
            //从最后一个元素到第一个元素累加
            println("list.reduceRight() = ${list.reduceRight { total, next -> total + next }}")
        }

        private fun sumBy() {
            //按照给定的表达式累加
            println("list.sumBy() = ${list.sumBy { it * 2 }}")
        }

        private fun drop() {
            list.forEach { print("$it ") }
            println("执行drop后元素")
            //去除前N个元素
            list.drop(5).forEach { print("$it ") }
        }

        private fun dropWhile() {
            println()
            // 从第一个元素进行比较，去除满足条件的集合元素，直到遇到第一个不满足条件的结束
            list.dropWhile { it <= 0 }.forEach(::println)
//            val list = arrayListOf(-1, -2, 0, 1, 2, 3, 100, 1000, 10000)
            //结果 1、2、3、100、1000、10000
        }

        private fun dropLastWhile() {
            //从最后一个元素进行比较，去除满足条件的集合元素，直到遇到第一个不满足条件的元素结束
            list.dropLastWhile { it > 0 }.forEach(::println)
        }

        private fun filter() {
            println("filter")
            //筛选符合条件的元素
            list.filter { it > 5 }.forEach(::println)
        }

        private fun filterNot() {
            println("filterNot")
            //筛选不符合条件的元素
            list.filterNot { it > 5 }.forEach(::println)
        }

        private fun filterNotNull() {
            println("filterNotNull")
            //返回不为null的集合元素
            list.filterNotNull().forEach(::println)
        }

        private fun slice() {
            println("slice")
            //返回索引对应元素集合
            list.slice(listOf(0, 1, 2)).forEach(::println)
            println("slice - IntRange")
            list.slice(IntRange(0, 2)).forEach(::println)
        }

        private fun take() {
            println("take")
            //返回前n个元素的集合
            list.take(4).forEach(::println)
        }

        private fun takeLast() {
            println("takeLast")
            //返回后n个元素的集合
            list.takeLast(4).forEach(::println)
        }

        private fun takeWhile() {
            println("takeWhile")
            //从第一个元素开始，返回符合条件的元素集合，直到出现第一个不满足条件的元素结束
            list.takeWhile { it >= -2 }.forEach(::println)
        }

        private fun flatMap() {
            println("flatMap")
            //通过遍历每个元素创建一个新的集合，然后把所有集合整合到包含所有元素的唯一列表中
            list.flatMap { list }.forEach(::println)
        }

        private fun groupBy() {
            println("groupBy")
            //根据给定条件把集合进行分组，return map
            list.groupBy { if (it % 2 == 0) "even" else "odd" }.forEach { key, value -> println("$key -> $value") }
        }

        private fun map() {
            println("map")
            //返回一个元素按照给定表达式进行计算的集合
            list.map { it * 2 }.forEach(::println)
        }

        private fun mapIndexed() {
            println("mapIndexed")
            //返回集合中索引以及对应运算后元素结果
            list.mapIndexed { index, i -> index * i }.forEach(::println)
        }

        private fun mapNotNull() {
            println("mapNotNull")
            //返回不为null的元素对应运算结果集合
            list.mapNotNull { it * 2 }.forEach(::println)
        }

        private fun contains() {
            println("contains")
            //集合中是否包含某元素或集合
            println("list contains 2:${list.contains(2)}")
        }

        private fun elementAt() {
            //集合中低2个元素
            println("the element of list at 2 is ${list.elementAt(2)}")
        }

        private fun elementAtOrElse() {
            //返回索引位置的值，如果索引超过范围返回默认值
            println("the element of list at 3 is ${list.elementAtOrElse(3, { it * 2 })}")
        }

        private fun elementAtOrNull() {
            //返回索引位置的值，如果超过范围返回null
            println("the element of list at 3 is ${list.elementAtOrNull(3)}")
        }

        private fun first() {
            //返回集合的第一个元素
            println("list.first() = ${list.first()}")
        }

        private fun indexOf() {
            //返回该元素在集合中对应的位置索引，如果不存在，返回-1
            println("2对应的索引：${list.indexOf(2)}")
        }

        private fun indexOfFirst() {
            //返回第一个元素为指定元素的位置索引，没有返回-1
            println("第一个为0的元素对应索引：${list.indexOfFirst { it == 0 }}")
        }

        private fun indexOfLast() {
            //返回最后一个元素为指定元素的位置索引，没有返回-1
            println("最后一个为0的元素对应索引：${list.indexOfLast { it == 0 }}")
        }

        private fun last() {
            //返回与指定条件相符的最后一个元素。
            println("返回取余为0的最后一个元素${list.last { it % 100 == 0 }}")
        }

        private fun lastIndexOf() {
            //返回集合中元素为指定元素的最后一位的位置索引，如果集合中不包含该元素，return -1
            println("返回元素为0的最后一位位置索引：${list.lastIndexOf(0)}")
        }

        private fun lastOrNull() {
            //返回集合中最后一个满足条件的元素，如果没有则返回null
            println("最后一个是3的倍数的元素：${list.lastOrNull { it % 3 == 0 }}")
        }

        private fun single() {
            //返回与指定条件相符的单一元素。如果没有或有多个相符的元素，则抛出异常。
            println("返回集合中唯一满足立方为8的元素：${list.single { Math.pow(it.toDouble(), 3.toDouble()) == 8.toDouble() }}")
        }

        private fun singleOrNull() {
            //返回与指定条件相符的单一元素。如果没有或有多个相符的元素，则返回null
            println("返回集合中唯一满足平方为4的元素：${list.singleOrNull { Math.pow(it.toDouble(), 2.toDouble()) == 4.toDouble() }}")
        }

        /************************************生成操作start***************************/
        private fun partition() {
            //按照给定的条件把集合分成两个部分，满足条件的放在first中，不符合条件的在second中
            val partition = list.partition { it % 2 == 0 }
            partition.first.forEach(::println)
            partition.second.forEach(::println)
        }

        private fun plus() {
            println("plus")
            //把两个集合合并成一个集合，把第二个集合中的元素放在最后
            list.plus(arrayListOf(1, 2, 3)).forEach(::println)
        }

        private fun zip() {
            println("zip")
            //返回一个列表，该列表由两个集合中相同索引元素建立的元素对。这个列表长度为最短集合的长度。
            list.zip(arrayListOf(1, 2, 3)).forEach(::println)
        }

        private fun minus() {
            println("minus")
            //返回第一个集合中去掉相同元素之后的集合
            arrayListOf(0, 1, 2, 4).minus(list).forEach(::println)
        }
        /************************************生成操作end***************************/

        /************************************排序操作Start************************/
        private fun reverse() {
            println("reverse")
            val arrayListOf = arrayListOf(1, 2, 3)
            //反序排序
            arrayListOf.reverse()
            println(arrayListOf)
        }

        private fun sort() {
            println("sort")
            val arrayListOf = arrayListOf(1, 3, 2, 5)
            //升序排序
            arrayListOf.sort()
            println(arrayListOf)
        }

        private fun sortBy() {
            println("sortBy")
            val arrayListOf = arrayListOf(1, 3, 2, 5)
            //按照特定条件升序排序
            arrayListOf.sortBy { Math.atan(it.toDouble()) }
            println(arrayListOf)
        }

        private fun sortDescending() {
            println("sortDescending")
            val arrayListOf = arrayListOf(1, 3, 2, 5)
            //降序排序
            arrayListOf.sortDescending()
            println(arrayListOf)
        }


        /************************************排序操作End************************/
    }
}