class Solution(object):
    def smallestSufficientTeam(self, req_skills, people):
        """
        :type req_skills: List[str]
        :type people: List[List[str]]
        :rtype: List[int]
        """
        dic = {}
        for i in range(len(req_skills)):
            dic[req_skills[i]] = i
        plist = []
        for item_list in people:
            val = 0
            for item in item_list:
                val += 2 ** dic[item]
            plist.append(val)
        for i in range(len(plist)):
            if plist[i] == 0:
                continue
            for j in range(i+1,len(plist)):
                if plist[i] | plist[j] == plist[i]:
                    plist[j] = 0
                elif plist[i] | plist[j] == plist[j]:
                    plist[i] = 0
                    break
        res = None
        queue = []
        for i, v in enumerate(plist):
            if v != 0: queue.append(([i], v))

        while len(queue) > 0:
            vl, v = queue.pop(0)
            if v == (2 ** (len(req_skills)) - 1):
                if (res == None or len(res) > len(vl)):
                    res = vl[:]
                continue
            elif res != None and len(vl) >= len(res):
                continue
            for i in range(vl[-1] + 1, len(plist)):
                if v | plist[i] == v:
                    continue
                elif v | plist[i] == plist[i]:
                    break
                else:
                    tl = vl[:] + [i]
                    queue.insert(0,(tl, v | plist[i]))
        return res
