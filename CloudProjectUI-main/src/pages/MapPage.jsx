import { useNavigate } from 'react-router-dom'

function MapPage({ userHook }) {
  const navigate = useNavigate()

  const signout = () => {
    userHook(null)
    navigate('/')
  }

  return (
    <div className="relative h-screen w-screen bg-[#30323D]">
      <iframe
        title="City map"
        src="/map.html"
        className="h-full w-full border-0"
      />
      <button
        type="button"
        className="fixed right-4 top-4 rounded-xl bg-[#30323D] px-5 py-3 font-bold text-gray-100 shadow-xl/20"
        style={{ zIndex: 9999 }}
        onClick={signout}
      >
        Sign out
      </button>
    </div>
  )
}

export default MapPage
